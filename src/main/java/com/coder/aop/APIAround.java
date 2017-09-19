package com.coder.aop;

import com.coder.constants.CommonConstants;
import com.coder.constants.ErrorConstants;
import com.coder.error.ErrorCodeException;
import com.coder.utils.JsonUtils;
import com.coder.version.OptimisticLockingException;
import java.lang.reflect.Constructor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class APIAround {

    private final static Logger LOGGER = Logger.getLogger(APIAround.class);

    @Around("execution(* com.coder.web..*(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        boolean putMDC = false;
        try {
            if (MDC.get(CommonConstants.TRACE_KEY) == null) {
                MDC.put(CommonConstants.TRACE_KEY, ThreadLocalRandom.current().nextLong() + "");
                putMDC = true;
            }
            Object result = jp.proceed();
            return result;
        } catch (Throwable e) {
            String requestArgs = JsonUtils.toJson(jp.getArgs());

            if (e instanceof ConstraintViolationException) {
                String errorMsg = ((ConstraintViolationException) e).getConstraintViolations().stream().map
                        (ConstraintViolation::getMessage).collect(Collectors.joining(" "));

                return getErrorResponse((MethodSignature) jp.getSignature(), ErrorConstants.INVALID_PARAMETER.getCode
                        (), errorMsg, jp.getTarget().getClass());
            }

            if (e instanceof ErrorCodeException) {
                return getErrorResponse((MethodSignature) jp.getSignature(), ((ErrorCodeException) e).getErrorCode(),
                        ((ErrorCodeException) e).getErrorMessage(), jp.getTarget().getClass());
            }

            if (e instanceof OptimisticLockingException) {
                return getErrorResponse((MethodSignature) jp.getSignature(), ErrorConstants.UPDATE_COUNT_ZERO.getCode
                        (), ErrorConstants.UPDATE_COUNT_ZERO.getDesc(), jp.getTarget().getClass());
            }
            LOGGER.error("error happen=>", e);

            return getErrorResponse((MethodSignature) jp.getSignature(), ErrorConstants.UNKNOWN_ERROR.getCode(),
                    ErrorConstants.UNKNOWN_ERROR.getDesc(), jp.getTarget().getClass());

        } finally {
            if (putMDC) {
                MDC.remove(CommonConstants.TRACE_KEY);
            }
        }
    }

    private Object getErrorResponse(MethodSignature methodSignature, int errorCode, String errorMsg, Class clazz) {
        try {
            if (clazz.getAnnotation(APIWrapper.class) != null) {
                Constructor<? extends ApiJsonResult> constructor = (methodSignature).getReturnType().getConstructor
                        (int.class, String.class);
                return constructor.newInstance(errorCode, errorMsg);
            }

            Constructor<? extends JsonResult> constructor = (methodSignature).getReturnType().getConstructor(int
                    .class, String.class);
            return constructor.newInstance(errorCode, errorMsg);

        } catch (Exception e) {
            return null;
        }
    }

}

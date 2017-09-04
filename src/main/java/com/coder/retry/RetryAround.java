package com.coder.retry;

import com.coder.retry.model.FailInfo;
import com.coder.retry.mapper.FailInfoMapper;
import com.coder.retry.model.RetryContext;
import com.coder.utils.JsonUtils;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryAround {
    private static final Logger logger = LoggerFactory.getLogger(RetryAround.class);

    @Resource
    private FailInfoMapper failInfoMapper;

    @Around("@annotation(com.coder.retry.Retry)")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        RetryContext context = getContext(jp);
        FailInfo failInfo = null;
        Object result = null;
        while (!context.isSuccess() && !context.stop()) {
            try {
                result = jp.proceed();
                context.setSuccess(true);
            } catch (Throwable throwable) {
                context.setLastThrowable(throwable);
                failInfo = failInfo == null ? buildFailInfo(jp, throwable) : failInfo;
                logger.info("retry {} times, className:{}, method:{}, params:{}", context.getRetryTimes(), failInfo
                        .getClassName(), failInfo.getMethod(), failInfo.getParams(), throwable);
                if (context.success(throwable)) {
                    context.setSuccess(true);
                    break;
                }
                context.increase();
            }
        }
        if (!context.isSuccess()) {
            saveFailInfo(failInfo);
            if (context.isRethrow()) {
                throw context.getLastThrowable();
            }
        }
        return result;
    }

    private RetryContext getContext(ProceedingJoinPoint jp) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        Retry retry = AnnotationUtils.findAnnotation(method, Retry.class);
        RetryContext context = new RetryContext();
        context.setRetryTimes(0);
        context.setMaxTimes(retry.maxTimes());
        context.setInclude(retry.include());
        context.setExclude(retry.exclude());
        context.setSuccess(false);
        context.setRethrow(retry.rethrow());
        return context;
    }

    private FailInfo buildFailInfo(ProceedingJoinPoint jp, Throwable throwable) {
        FailInfo failInfo = new FailInfo();
        failInfo.setClassName(jp.getTarget().getClass().getName());
        failInfo.setMethod(jp.getSignature().getName());
        failInfo.setParams(JsonUtils.toJson(jp.getArgs()));
        failInfo.setException(buildException(throwable));
        Date now = new Date();
        failInfo.setCreated(now);
        failInfo.setModified(now);
        return failInfo;
    }

    private void saveFailInfo(FailInfo failInfo) {
        failInfoMapper.insert(failInfo);
    }

    private String buildException(Throwable throwable) {
        return throwable.toString() + Stream.of(throwable.getStackTrace()).map(StackTraceElement::toString).collect
                (Collectors.joining());
    }

}

package com.coder.version;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.util.Assert;

public class OptimisticLockInterceptor implements MethodInterceptor, Serializable {
    private static final long serialVersionUID = 945503830988072674L;
    private static final Logger LOGGER = LoggerFactory.getLogger(OptimisticLockInterceptor.class);
    private OptimisticLockSource optimisticLockSource;

    public OptimisticLockInterceptor() {
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Class<?> targetClass = this.getTargetClass(invocation.getThis());
        OptimisticLock optimisticLock = this.optimisticLockSource.getOptimisticLockAnnotation(method, targetClass);
        if (optimisticLock != null) {
            Object res = invocation.proceed();
            Assert.isInstanceOf(Number.class, res, "OptimisticLockInterceptor target method return type must be " +
                    "Numer!");
            Number affectRow = (Number) res;
            if (optimisticLock.expect() != affectRow.intValue()) {
                LOGGER.debug("Optimistic lock failed. Method:{}, affect rows:{}, expect:{}", new Object[]{method,
                        affectRow, Integer.valueOf(optimisticLock.expect())});
                throw new OptimisticLockingException(method.getName());
            } else {
                return res;
            }
        } else {
            return invocation.proceed();
        }
    }

    private Class<?> getTargetClass(Object target) {
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(target);
        if (targetClass == null && target != null) {
            targetClass = target.getClass();
        }

        return targetClass;
    }

    public void setOptimisticLockSource(OptimisticLockSource optimisticLockSource) {
        this.optimisticLockSource = optimisticLockSource;
    }
}

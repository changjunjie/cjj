package com.coder.version;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;

public class OptimisticLockSource implements Serializable {
    private static final long serialVersionUID = 7321806917817782997L;
    private final Map<Object, OptimisticLock> optimisticLockCache = new ConcurrentHashMap(1024);

    public OptimisticLockSource() {
    }

    public OptimisticLock getOptimisticLockAnnotation(Method method, Class<?> targetClass) {
        AnnotatedElementKey cacheKey = new AnnotatedElementKey(method, targetClass);
        OptimisticLock cachedOptimisticLock = (OptimisticLock) this.optimisticLockCache.get(cacheKey);
        if (cachedOptimisticLock != null) {
            return cachedOptimisticLock;
        } else {
            OptimisticLock optimisticLock = this.findAnnotation(method, targetClass);
            if (optimisticLock != null) {
                this.optimisticLockCache.put(cacheKey, optimisticLock);
            }

            return optimisticLock;
        }
    }

    private OptimisticLock findAnnotation(Method method, Class<?> targetClass) {
        Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
        specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);
        OptimisticLock optimisticLock = (OptimisticLock) specificMethod.getAnnotation(OptimisticLock.class);
        if (optimisticLock != null) {
            return optimisticLock;
        } else {
            if (specificMethod != method) {
                optimisticLock = (OptimisticLock) method.getAnnotation(OptimisticLock.class);
                if (optimisticLock != null) {
                    return optimisticLock;
                }
            }

            return null;
        }
    }
}

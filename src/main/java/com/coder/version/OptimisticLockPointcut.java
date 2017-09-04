package com.coder.version;


import java.io.Serializable;
import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.util.ObjectUtils;

public class OptimisticLockPointcut extends StaticMethodMatcherPointcut implements Serializable {
    private static final long serialVersionUID = -4645924473792187962L;
    private OptimisticLockSource optimisticLockSource;

    public OptimisticLockPointcut() {
    }

    public boolean matches(Method method, Class<?> targetClass) {
        return this.optimisticLockSource != null && this.optimisticLockSource.getOptimisticLockAnnotation(method,
                targetClass) != null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof OptimisticLockPointcut)) {
            return false;
        } else {
            OptimisticLockPointcut otherPc = (OptimisticLockPointcut) other;
            return ObjectUtils.nullSafeEquals(this.optimisticLockSource, otherPc.getOptimisticLockSource());
        }
    }

    public int hashCode() {
        return OptimisticLockPointcut.class.hashCode();
    }

    public String toString() {
        return this.getClass().getName() + ": " + this.getOptimisticLockSource();
    }

    public OptimisticLockSource getOptimisticLockSource() {
        return this.optimisticLockSource;
    }

    public void setOptimisticLockSource(OptimisticLockSource optimisticLockSource) {
        this.optimisticLockSource = optimisticLockSource;
    }
}
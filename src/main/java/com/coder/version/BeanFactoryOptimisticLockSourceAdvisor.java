package com.coder.version;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.util.Assert;

public class BeanFactoryOptimisticLockSourceAdvisor extends AbstractBeanFactoryPointcutAdvisor {
    private static final long serialVersionUID = -5137550734811005932L;
    private OptimisticLockPointcut pointcut = new OptimisticLockPointcut();

    public BeanFactoryOptimisticLockSourceAdvisor() {
    }

    public Pointcut getPointcut() {
        return this.pointcut;
    }

    public void setOptimisticLockSource(OptimisticLockSource optimisticLockSource) {
        Assert.notNull(optimisticLockSource, "OptimisticLockSource can not be null!");
        this.pointcut.setOptimisticLockSource(optimisticLockSource);
    }

    public void setClassFilter(ClassFilter classFilter) {
        this.pointcut.setClassFilter(classFilter);
    }
}

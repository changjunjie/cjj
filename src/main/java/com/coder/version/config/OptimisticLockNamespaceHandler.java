package com.coder.version.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class OptimisticLockNamespaceHandler extends NamespaceHandlerSupport {
    public OptimisticLockNamespaceHandler() {
    }

    public void init() {
        this.registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenOptimisticLockBeanDefinitionParser
                ());
    }
}

package com.coder.version.config;

import com.coder.version.BeanFactoryOptimisticLockSourceAdvisor;
import com.coder.version.OptimisticLockInterceptor;
import org.springframework.aop.config.AopNamespaceUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.parsing.CompositeComponentDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

class AnnotationDrivenOptimisticLockBeanDefinitionParser implements BeanDefinitionParser {
    AnnotationDrivenOptimisticLockBeanDefinitionParser() {
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String mode = element.getAttribute("mode");
        if ("aspectj".equals(mode)) {
            throw new RuntimeException("Unsupported aspectj mode!");
        } else {
            AopNamespaceUtils.registerAutoProxyCreatorIfNecessary(parserContext, element);
            AnnotationDrivenOptimisticLockBeanDefinitionParser.SpringCachingConfigurer.registerCacheAdvisor(element,
                    parserContext);
            return null;
        }
    }

    private static class SpringCachingConfigurer {
        private static final String DEFAULT_ADVISOR = "com.coder.version.internalOptimisticLockAdvisor";

        private SpringCachingConfigurer() {
        }

        private static void registerCacheAdvisor(Element element, ParserContext parserContext) {
            if (!parserContext.getRegistry().containsBeanDefinition("com.coder.version.internalOptimisticLockAdvisor")) {
                Object eleSource = parserContext.extractSource(element);
                RootBeanDefinition sourceDef = new RootBeanDefinition("com.coder.version.OptimisticLockSource");
                sourceDef.setSource(eleSource);
                sourceDef.setRole(2);
                String sourceName = parserContext.getReaderContext().registerWithGeneratedName(sourceDef);
                RootBeanDefinition interceptorDef = new RootBeanDefinition(OptimisticLockInterceptor.class);
                RuntimeBeanReference sourceRefer = new RuntimeBeanReference(sourceName);
                interceptorDef.setSource(eleSource);
                interceptorDef.setRole(2);
                interceptorDef.getPropertyValues().add("optimisticLockSource", sourceRefer);
                String interceptorName = parserContext.getReaderContext().registerWithGeneratedName(interceptorDef);
                RootBeanDefinition advisorDef = new RootBeanDefinition(BeanFactoryOptimisticLockSourceAdvisor.class);
                advisorDef.setSource(eleSource);
                advisorDef.setRole(2);
                advisorDef.getPropertyValues().add("optimisticLockSource", sourceRefer);
                advisorDef.getPropertyValues().add("adviceBeanName", interceptorName);
                if (element.hasAttribute("order")) {
                    advisorDef.getPropertyValues().add("order", element.getAttribute("order"));
                }

                parserContext.getRegistry().registerBeanDefinition("com.coder.version.internalOptimisticLockAdvisor",
                        advisorDef);
                CompositeComponentDefinition compositeDef = new CompositeComponentDefinition(element.getTagName(),
                        eleSource);
                compositeDef.addNestedComponent(new BeanComponentDefinition(sourceDef, sourceName));
                compositeDef.addNestedComponent(new BeanComponentDefinition(interceptorDef, interceptorName));
                compositeDef.addNestedComponent(new BeanComponentDefinition(advisorDef, "com.coder.version.internalOptimisticLockAdvisor"));
                parserContext.registerComponent(compositeDef);
            }
        }
    }
}

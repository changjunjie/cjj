package com.coder.retry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {

    int maxTimes() default 1;

    boolean rethrow() default true;

    Class<? extends Throwable>[] include() default {};

    Class<? extends Throwable>[] exclude() default {};
}

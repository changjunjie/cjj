package com.coder.retry;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * spring configuration
 *
 * @author shaomingxing on 2017/8/24.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.coder.retry")
public class RetryConfiguration {

}

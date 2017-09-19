package com.coder.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

public abstract class AbstractDBConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    private String prefix = "spring.datasource.";

    @Override
    public void setEnvironment(Environment environment) {
        propertyResolver = new RelaxedPropertyResolver(environment, prefix);
    }

    public DataSource dataSource(RelaxedPropertyResolver resolver) {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(resolver.getProperty("url"));
        dataSource.setUsername(resolver.getProperty("username"));
        dataSource.setPassword(resolver.getProperty("password"));

        String driverClassName = resolver.getProperty("driverClassName");
        if (StringUtils.isEmpty(driverClassName)) {
            driverClassName = propertyResolver.getProperty("driverClassName");
        }
        dataSource.setDriverClassName(driverClassName);

        String initialSize = resolver.getProperty("initialSize");
        if (StringUtils.isEmpty(initialSize)) {
            initialSize = propertyResolver.getProperty("initialSize");
        }
        dataSource.setInitialSize(Integer.parseInt(initialSize));

        String minIdle = resolver.getProperty("minIdle");
        if (StringUtils.isEmpty(minIdle)) {
            minIdle = propertyResolver.getProperty("minIdle");
        }
        dataSource.setMinIdle(Integer.parseInt(minIdle));

        String maxActive = resolver.getProperty("maxActive");
        if (StringUtils.isEmpty(maxActive)) {
            maxActive = propertyResolver.getProperty("maxActive");
        }
        dataSource.setMaxActive(Integer.parseInt(maxActive));

        String maxWait = resolver.getProperty("maxWait");
        if (StringUtils.isEmpty(maxWait)) {
            maxWait = propertyResolver.getProperty("maxWait");
        }
        dataSource.setMaxWait(Integer.parseInt(maxWait));

        String timeBetweenEvictionRunsMillis = resolver.getProperty("timeBetweenEvictionRunsMillis");
        if (StringUtils.isEmpty(timeBetweenEvictionRunsMillis)) {
            timeBetweenEvictionRunsMillis = propertyResolver.getProperty("timeBetweenEvictionRunsMillis");
        }
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(timeBetweenEvictionRunsMillis));

        String minEvictableIdleTimeMillis = resolver.getProperty("minEvictableIdleTimeMillis");
        if (StringUtils.isEmpty(minEvictableIdleTimeMillis)) {
            minEvictableIdleTimeMillis = propertyResolver.getProperty("minEvictableIdleTimeMillis");
        }
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(minEvictableIdleTimeMillis));

        String validationQuery = resolver.getProperty("validationQuery");
        if (StringUtils.isEmpty(validationQuery)) {
            validationQuery = propertyResolver.getProperty("validationQuery");
        }
        dataSource.setValidationQuery(validationQuery);

        String testWhileIdle = resolver.getProperty("testWhileIdle");
        if (StringUtils.isEmpty(testWhileIdle)) {
            testWhileIdle = propertyResolver.getProperty("testWhileIdle");
        }
        dataSource.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));

        String testOnBorrow = resolver.getProperty("testOnBorrow");
        if (StringUtils.isEmpty(testOnBorrow)) {
            testOnBorrow = propertyResolver.getProperty("testOnBorrow");
        }
        dataSource.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));

        String testOnReturn = resolver.getProperty("testOnReturn");
        if (StringUtils.isEmpty(testOnReturn)) {
            testOnReturn = propertyResolver.getProperty("testOnReturn");
        }
        dataSource.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
        return dataSource;
    }

}
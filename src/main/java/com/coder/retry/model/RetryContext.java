package com.coder.retry.model;

public class RetryContext {
    private boolean success = false;
    private int retryTimes = 0;
    private int maxTimes;
    private boolean rethrow;
    private Class<? extends Throwable>[] include;
    private Class<? extends Throwable>[] exclude;

    private Throwable lastThrowable;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public int getMaxTimes() {
        return maxTimes;
    }

    public void setMaxTimes(int maxTimes) {
        this.maxTimes = maxTimes;
    }

    public boolean isRethrow() {
        return rethrow;
    }

    public void setRethrow(boolean rethrow) {
        this.rethrow = rethrow;
    }

    public Class<? extends Throwable>[] getInclude() {
        return include;
    }

    public void setInclude(Class<? extends Throwable>[] include) {
        this.include = include;
    }

    public Class<? extends Throwable>[] getExclude() {
        return exclude;
    }

    public void setExclude(Class<? extends Throwable>[] exclude) {
        this.exclude = exclude;
    }

    public Throwable getLastThrowable() {
        return lastThrowable;
    }

    public void setLastThrowable(Throwable lastThrowable) {
        this.lastThrowable = lastThrowable;
    }

    public void increase() {
        retryTimes++;
    }

    public boolean stop() {
        return retryTimes > maxTimes;
    }

    public boolean success(Throwable throwable) {
        Class<? extends Throwable> clazz = throwable.getClass();
        for (Class<? extends Throwable> in : include) {
            if (clazz.isAssignableFrom(in)) {
                return false;
            }
        }
        for (Class<? extends Throwable> ex : exclude) {
            if (clazz.isAssignableFrom(ex)) {
                return true;
            }
        }
        return false;
    }
}

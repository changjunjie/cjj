package com.coder.version;

public class OptimisticLockingException extends RuntimeException {
    private static final long serialVersionUID = -8879525250880790138L;

    public OptimisticLockingException() {
    }

    public OptimisticLockingException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptimisticLockingException(String message) {
        super(message);
    }

}

package com.coder.error;

import com.coder.constants.ErrorConstants;

public class ErrorCodeException extends RuntimeException {

    private ErrorConstants.ErrorPair errorInfo;

    public ErrorCodeException(ErrorConstants.ErrorPair errorInfo) {
        super(errorInfo.getCode() + " " + errorInfo.getDesc());
        this.errorInfo = errorInfo;
    }

    public ErrorCodeException(ErrorConstants.ErrorPair errorInfo, Exception e) {
        super(errorInfo.getCode() + " " + errorInfo.getDesc() + " " + e.getMessage(), e);
        this.errorInfo = errorInfo;
    }

    public int getErrorCode() {
        return errorInfo.getCode();
    }

    public String getErrorMessage() {
        return errorInfo.getDesc();
    }
}

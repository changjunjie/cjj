package com.coder.aop;

import com.coder.constants.ErrorConstants;

public class ApiJsonResult<T> {

    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "success";

    private long code;

    private String message;

    private T result;

    public ApiJsonResult() {
        this.code = SUCCESS;
        this.message = SUCCESS_MSG;
    }

    public ApiJsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ApiJsonResult<T> success(T t) {
        ApiJsonResult<T> jr = new ApiJsonResult<>();
        jr.code = SUCCESS;
        jr.message = SUCCESS_MSG;
        jr.result = t;
        return jr;
    }

    public static ApiJsonResult fail() {
        ApiJsonResult jr = new ApiJsonResult();
        jr.code = ErrorConstants.UNKNOWN_ERROR.getCode();
        jr.message = ErrorConstants.UNKNOWN_ERROR.getDesc();
        return jr;
    }

    public static ApiJsonResult fail(int code, String message) {
        ApiJsonResult jr = new ApiJsonResult();
        jr.code = code;
        jr.message = message;
        return jr;
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

package com.coder.aop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonResult<T> {

    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "success";
    public static final int FAIL = -1;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private int errorNo;

    private String errorMsg;

    private String timestamp = LocalDateTime.now().format(DTF);

    private T data;

    public JsonResult() {
    }

    public JsonResult(int errorNo) {
        this.errorNo = errorNo;
    }

    public JsonResult(int errorNo, String errorMsg) {
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
    }

    public static JsonResult failureResult() {
        return new JsonResult(FAIL);
    }

    public static JsonResult failureResult(String error) {
        return failureResult(FAIL, error);
    }

    public static JsonResult failureResult(int code, String error) {
        return new JsonResult(code, error);
    }

    public static JsonResult successResult() {
        return new JsonResult(SUCCESS, SUCCESS_MSG);
    }

    public static <T> JsonResult<T> successResult(T t) {
        return new JsonResult<T>(SUCCESS).setData(t);
    }

    public static JsonResult successResult(int code, String msg) {
        return new JsonResult(code, msg);
    }

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public JsonResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}

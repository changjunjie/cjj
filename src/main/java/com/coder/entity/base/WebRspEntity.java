package com.coder.entity.base;

import com.coder.error.BaseException;
import com.coder.error.CodeEnum;

/**
 * 返回实体
 *
 * @author changjunjie
 * @since 26.05.2017
 */
public class WebRspEntity<T> {

    /**
     * 状态码
     */
    private int errorNo;
    /**
     * 错误消息内容
     */
    private String errorMsg;
    /**
     * 正确时返回的数据
     */
    private T data;

    public WebRspEntity() {
    }

    public WebRspEntity(int code, String message) {
        this(code, message, null);
    }

    public WebRspEntity(CodeEnum error) {
        this(error.getCode(), error.getMessage());
    }

    public WebRspEntity(CodeEnum error, T data) {
        this(error.getCode(), error.getMessage(), data);
    }

    public WebRspEntity(int code, String message, T data) {
        errorNo = code;
        errorMsg = message;
        this.data = data;
    }

    public WebRspEntity(BaseException ex) {
        this(ex.getCode(), ex.getMessage());
    }

    /**
     * Gets the 404.html no.
     *
     * @return the 404.html no
     */
    public int getErrorNo() {
        return errorNo;
    }

    /**
     * Sets the 404.html no.
     *
     * @param errorNo the new 404.html no
     */
    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    /**
     * Gets the 404.html msg.
     *
     * @return the 404.html msg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Sets the 404.html msg.
     *
     * @param errorMsg the new 404.html msg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(T data) {
        this.data = data;
    }
}

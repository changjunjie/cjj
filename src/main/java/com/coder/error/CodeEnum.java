package com.coder.error;

import com.coder.utils.EnumUtils;
import java.util.HashMap;
import java.util.Map;

public enum CodeEnum {

    SUCCESS(0, "success"),
    UNKNOWN_ERROR(-1, "未知错误"),
    IDENTITY_FAIL(1, "Authentication failed"),
    PARAMETER_ERROR(2, "parameter 404.html"),
    RESPONSE_ERROR(3, "response 404.html"),
    SIGN_VERIFY_FAIL(4, "response sign verify fail"),
    NO_DATA(5, "no data"),
    NAME_ERROE(6, "用户名不正确"),
    ALREADY_LOGIN(7, "已经登录"),
    INIT_KEY(8, "初始化密钥失败"),
    CONNECTION_REFUSED(9, "Connection refused");

    // 从错误码反查
    private static Map<Integer, CodeEnum> mapErr = new HashMap();

    static {
        for (CodeEnum e : CodeEnum.values()) {
            mapErr.put(e.getCode(), e);
        }
    }

    private int errNo;
    private String errMsg;

    CodeEnum(int errNo, String errMsg) {
        this.errNo = errNo;
        this.errMsg = errMsg;
    }

    public static CodeEnum codeOf(Integer errCode) {
        return mapErr.get(errCode);
    }

    public static CodeEnum codeOf(String errCode) {
        try {
            return codeOf(Integer.valueOf(errCode));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static CodeEnum nameOf(String name) {
        return EnumUtils.valueOf(CodeEnum.class, name);
    }

    public String getMessage() {
        return errMsg;
    }

    public int getCode() {
        return errNo;
    }
}


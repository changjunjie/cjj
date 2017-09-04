package com.coder.utils;

import org.springframework.util.StringUtils;

public class EnumUtils {
    /**
     * 通过名称获取到枚举值
     * 约定：枚举值为大写+下划线
     *
     * @param clz
     * @param name
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T valueOf(Class<T> clz, String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        name = name.trim().toUpperCase();
        try {
            return Enum.valueOf(clz, name);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 枚举的字面值与字符串是否相等
     *
     * @param n
     * @param s
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> boolean equals(T n, String s) {
        return n.name().equalsIgnoreCase(s);
    }

    /**
     * 枚举的字符值与字符串是否相等
     *
     * @param s
     * @param n
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> boolean equals(String s, T n) {
        return equals(n, s);
    }

    public static <T extends Enum<T>> boolean equalsAny(String s, T... args) {
        for (T t : args) {
            if (equals(s, t)) {
                return true;
            }
        }
        return false;
    }
}

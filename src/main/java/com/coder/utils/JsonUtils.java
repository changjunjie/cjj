package com.coder.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T toBean(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("json {} to bean by class {} error", json, clazz, e);
            return null;
        }
    }

    public static <T> T toBean(String json, TypeReference<T> tr) {
        try {
            return MAPPER.readValue(json, tr);
        } catch (IOException e) {
            logger.error("json {} to bean by class {} error", json, tr.getType().getTypeName(), e);
            return null;
        }
    }

    public static <T> String toJson(T t) {
        if (t instanceof String) {
            return (String) t;
        }
        try {
            return MAPPER.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            logger.error("bean {} to json error", t, e);
            return null;
        }
    }

    public static Map<String, Object> toMap(String json) {
        try {
            return MAPPER.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            logger.error("json {} to map error", json, e);
            return null;
        }

    }

    public static Map<String, Object> bean2Map(Object obj) {
        try {
            return MAPPER.convertValue(obj, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            logger.error("{} can't convert to map", obj, e);
            return null;
        }
    }
}

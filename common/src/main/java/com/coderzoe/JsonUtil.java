package com.coderzoe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author coderZoe
 * @date 2022/3/23 18:21
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static<T>T parseObject(String json,Class<T> tClass) throws JsonProcessingException {
        return objectMapper.readValue(json,tClass);
    }

    public static String parseJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}

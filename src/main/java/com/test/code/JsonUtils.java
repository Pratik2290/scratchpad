package com.test.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.code.tw.Output;
import com.test.code.tw.SampleOutput;
import com.test.code.tw.ThoughtWorks;

import java.io.IOException;

public class JsonUtils {

    public static <T> T convertJSONToObject(String json, Class<T> aClass) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return (T) objectMapper.readValue(json, aClass);
        } catch (IOException e) {
            System.out.println(e);
            throw e;
        }
    }

    public static String convertObjectToJson(Output aClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(aClass);
    }
}

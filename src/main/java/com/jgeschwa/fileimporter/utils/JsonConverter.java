package com.jgeschwa.fileimporter.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;


@RequiredArgsConstructor
public class JsonConverter{

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convert(String content, Class<T> clazz) {
        try {
            return objectMapper.readValue(content, clazz);
        } catch (JsonProcessingException e) {
            // TODO implement custom exception
            throw new RuntimeException();
        }
    }

    public static <T> List<T> convertList(String content, Class<? extends Collection> type, Class<T> elementType) {
        try {
            return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(type, elementType));
        } catch (JsonProcessingException e) {
            // TODO implement custom exception
            throw new RuntimeException();
        }
    }
}

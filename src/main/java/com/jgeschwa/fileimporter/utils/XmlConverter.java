package com.jgeschwa.fileimporter.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class XmlConverter {

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static <T> T convert(String content, Class<T> clazz) {
        try {
            return xmlMapper.readValue(content, clazz);
        } catch (JsonProcessingException e) {
            // TODO implement custom exception
            throw new RuntimeException();
        }
    }

    public static <T> List<T> convertList(String content, Class<? extends Collection> type, Class<T> elementType) {
        try {
            return xmlMapper.readValue(content, xmlMapper.getTypeFactory().constructCollectionType(type, elementType));
        } catch (JsonProcessingException e) {
            // TODO implement custom exception
            throw new RuntimeException();
        }
    }
}

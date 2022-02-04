package com.github.kirovj.seen.component.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * @author : kirovj
 * @date : 2022/2/4 20:57
 */
public class JSONUtils {

    private JSONUtils() {}

    private static final ObjectReader reader;

    private static final ObjectWriter writer;

    static {
        var mapper = new ObjectMapper();
        reader = mapper.reader();
        writer = mapper.writer();
    }

    public static <T> String toStr(T t) throws JsonProcessingException {
        return writer.writeValueAsString(t);
    }

    public static <T> T toObj(String s, Class<T> clazz) throws JsonProcessingException {
        return reader.forType(clazz).readValue(s);
    }

    public static <T> T toObj(String s, TypeReference<T> type) throws JsonProcessingException {
        return reader.forType(type).readValue(s);
    }
}

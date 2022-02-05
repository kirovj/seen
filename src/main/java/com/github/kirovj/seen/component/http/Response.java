package com.github.kirovj.seen.component.http;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author : kirovj
 * @date : 2022/2/4 20:43
 */
public record Response<T>(int status, T data, String msg) {

    public static <T> Response<T> ok(T data) {
        return new Response<>(Status.Success.code(), data, "ok");
    }

    public static <T> Response<List<T>> errFromSpringMap(Map<?, ?> map) {
        int status = Status.Fail.code();
        String msg = String.valueOf(map.get("error"));
        try {
            status = Integer.parseInt(String.valueOf(map.get("status")));
        } catch (NumberFormatException ignored) {
        }
        return new Response<>(status, Collections.emptyList(), msg);
    }

    public static <T> Response<List<T>> err(String msg) {
        return err(Status.Fail.code(), msg);
    }

    public static <T> Response<List<T>> err(int code, String msg) {
        return new Response<>(code, Collections.emptyList(), msg);
    }
}

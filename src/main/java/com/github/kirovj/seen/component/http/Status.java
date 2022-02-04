package com.github.kirovj.seen.component.http;

/**
 * @author : kirovj
 * @date : 2022/2/4 20:43
 */
public enum Status {
    Success(200),
    Fail(-1),
    ;

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}

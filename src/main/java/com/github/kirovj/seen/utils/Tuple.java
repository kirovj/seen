package com.github.kirovj.seen.utils;

import lombok.Data;

/**
 * Tuple
 *
 * @author : kirovj
 * @date : 2022/6/5 5:55
 */
@Data
public class Tuple<X, Y> {

    private X x;

    private Y y;

    private Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public static <X, Y> Tuple<X, Y> of(X x, Y y) {
        return new Tuple<>(x, y);
    }
}

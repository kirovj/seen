package com.github.kirovj.seen.domain.entity;

import com.github.kirovj.seen.domain.enums.Type;

/**
 * todo
 *
 * @author : kirovj
 * @date : 2021/10/25 1:24
 */
public record Searcher(String name,
                       Type type,
                       boolean valid,
                       boolean watched,
                       int year,
                       String country,
                       String director) {
}

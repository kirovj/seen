package com.github.kirovj.seen.domain.entity;

import com.github.kirovj.seen.domain.enums.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Searcher
 *
 * @author : kirovj
 * @date : 2021/10/25 1:24
 */
@Getter
@Setter
@Accessors(chain = true)
public class Searcher {
    private String name;
    private Type type;
    private boolean valid;
    private boolean watched;
    private int year;
    private String country;
    private String director;
}

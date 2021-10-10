package com.github.kirovj.seen.domain.modal;

import com.github.kirovj.seen.domain.enums.VideoType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Video, contains movie, series, web videos, etc.
 *
 * @author : kirovj
 * @date : 2021/10/10 16:21
 */
@Getter
@Setter
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Video name
     */
    private String name;

    private VideoType type;
}

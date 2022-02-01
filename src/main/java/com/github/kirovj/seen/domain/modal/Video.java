package com.github.kirovj.seen.domain.modal;

import com.github.kirovj.seen.domain.enums.Type;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Video name
     */
    @Column(length = 128)
    private String name;

    /**
     * Video type
     */
    private Type type;

    /**
     * create time
     */
    @CreationTimestamp
    private Timestamp createTime;

    /**
     * last modify time
     */
    @UpdateTimestamp
    private Timestamp modifyTime;

    /**
     * 封面图片 base64
     */
    @Column(columnDefinition = "TEXT")
    private String image;

    /**
     * is valid
     */
    private boolean valid = true;

    /**
     * is watched
     */
    private boolean watched = false;

    /**
     * 年份
     */
    private int year;

    /**
     * 首映日期
     */
    @Column(length = 24)
    private String date;

    /**
     * 制片国家/地区
     */
    @Column(length = 24)
    private String country;

    /**
     * 导演
     */
    @Column(length = 24)
    private String director;

    /**
     * 介绍
     */
    @Column(columnDefinition = "TEXT")
    private String intro;

    /**
     * 评价
     */
    @Column(columnDefinition = "TEXT")
    private String comment;
}

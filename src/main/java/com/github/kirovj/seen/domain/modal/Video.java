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
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    /**
     * Video name
     */
    @Column(length = 128)
    protected String name;

    /**
     * Video type
     */
    protected Type type;

    /**
     * create time
     */
    @CreationTimestamp
    protected Timestamp ctime;

    /**
     * last modify time
     */
    @UpdateTimestamp
    protected Timestamp mtime;

    /**
     * 封面图片 base64
     */
    @Column(columnDefinition = "TEXT")
    private String img;

    /**
     * is valid
     */
    protected boolean valid = true;

    /**
     * is watched
     */
    protected boolean watched = false;

    /**
     * 评分
     */
    private float rating;

    /**
     * 评分人数
     */
    private int ratingCnt;

    /**
     * 年份
     */
    private int year;

    /**
     * 首映日期
     */
    private String date;

    /**
     * 制片国家/地区
     */
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

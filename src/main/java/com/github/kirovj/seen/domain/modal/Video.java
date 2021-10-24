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

    /* --------------- private --------------- */

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

    /* ------------- Builder -------------- */

    public static Video builder() {
        return new Video();
    }

    public Video name(String name) {
        this.name = name;
        return this;
    }

    public Video type(Type type) {
        this.type = type;
        return this;
    }

    public Video img(String img) {
        this.img = img;
        return this;
    }

    public Video valid(boolean valid) {
        this.valid = valid;
        return this;
    }

    public Video watched(boolean watched) {
        this.watched = watched;
        return this;
    }

    public Video rating(float rating) {
        this.rating = rating;
        return this;
    }

    public Video ratingCnt(int ratingCnt) {
        this.ratingCnt = ratingCnt;
        return this;
    }

    public Video year(int year) {
        this.year = year;
        return this;
    }

    public Video date(String date) {
        this.date = date;
        return this;
    }

    public Video country(String country) {
        this.country = country;
        return this;
    }

    public Video director(String director) {
        this.director = director;
        return this;
    }

    public Video intro(String intro) {
        this.intro = intro;
        return this;
    }

    public Video comment(String comment) {
        this.comment = comment;
        return this;
    }
}

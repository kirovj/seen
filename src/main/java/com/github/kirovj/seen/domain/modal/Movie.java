package com.github.kirovj.seen.domain.modal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author : kirovj
 * @date : 2021/10/16 20:00
 */
@Getter
@Setter
@Entity
public class Movie extends Video {

    @Column(length = 128)
    private String nameZh;

    @Column(length = 128)
    private String nameFn;

    // 评分
    private float rating;
    // 评分人数
    private int ratingCnt;

    // 年份
    private int year;

    // 首映日期
    private String date;

    // 制片国家/地区
    private String country;

    @Column(length = 24)
    private String director;

    @Column(length = 1024)
    private String img;

    @Column(columnDefinition = "TEXT")
    private String imgBase64;

    @Column(columnDefinition = "TEXT")
    private String intro;

    @Column(length = 24)
    private String imdb;

    @Column(length = 256)
    private String douban;

    @Column(columnDefinition = "TEXT")
    private String comment;
}

package com.github.kirovj.seen.domain.modal;

import com.github.kirovj.seen.domain.enums.RatingSource;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Rating
 *
 * @author : kirovj
 * @date : 2022/2/1 22:35
 */
@Getter
@Setter
@Accessors(fluent = true)
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 是否有效
     */
    private boolean valid;

    /**
     * 视频 id
     */
    private int videoId;

    /**
     * 分数
     */
    private float score;

    /**
     * 打分人数
     */
    private int count;

    /**
     * 分数来源
     */
    private RatingSource source;
}

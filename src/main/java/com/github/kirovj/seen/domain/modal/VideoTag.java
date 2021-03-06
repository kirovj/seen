package com.github.kirovj.seen.domain.modal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * video & tag link
 *
 * @author : kirovj
 * @date : 2021/10/24 0:14
 */
@Getter
@Setter
@Entity
public class VideoTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    private int videoId;

    private int tagId;
}

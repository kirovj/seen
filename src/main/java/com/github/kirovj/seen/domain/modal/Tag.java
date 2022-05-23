package com.github.kirovj.seen.domain.modal;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Video tag
 *
 * @author : kirovj
 * @date : 2021/10/23 23:56
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}

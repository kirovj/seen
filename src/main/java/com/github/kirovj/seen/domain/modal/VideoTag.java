package com.github.kirovj.seen.domain.modal;

import com.github.kirovj.seen.domain.enums.Type;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    private Type type;

    private long videoId;

    private int tagId;
}

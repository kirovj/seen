package com.github.kirovj.seen.domain.modal;

import com.github.kirovj.seen.domain.enums.VideoType;
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
@MappedSuperclass
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
    protected VideoType type;

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
     * is valid
     */
    protected boolean valid = true;

    /**
     * is watched
     */
    protected boolean watched = false;
}

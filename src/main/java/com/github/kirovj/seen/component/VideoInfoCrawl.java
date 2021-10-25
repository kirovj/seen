package com.github.kirovj.seen.component;

import com.github.kirovj.seen.domain.modal.Video;

/**
 * @author : kirovj
 * @date : 2021/10/25 23:29
 */
public interface VideoInfoCrawl {

    Video crawl(String url);
}

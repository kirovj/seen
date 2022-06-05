package com.github.kirovj.seen.component;

import com.github.kirovj.seen.domain.enums.Type;
import com.github.kirovj.seen.domain.modal.Tag;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.TagService;
import com.github.kirovj.seen.service.VideoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : kirovj
 * @date : 2022/2/1 22:47
 */
@Component
public class DatabaseTest implements CommandLineRunner {

    private final VideoService videoService;

    private final TagService tagService;

    public DatabaseTest(VideoService videoService, TagService tagService) {
        this.videoService = videoService;
        this.tagService = tagService;
    }

    @Override
    public void run(String... strings) {
        initTags();
        initVideos();
    }

    private void initVideos() {
        var v1 = new Video().setName("testMovie").setType(Type.Movie);
        var v2 = new Video().setName("testSeries").setType(Type.Series);
        var v3 = new Video().setName("ADN-123").setType(Type.Adult);
        videoService.add(v1);
        videoService.add(v2);
        videoService.add(v3);
    }

    private void initTags() {
        var t1 = new Tag().setName("惊悚");
        var t2 = new Tag().setName("科幻");
        tagService.add(t1);
        tagService.add(t2);
    }
}

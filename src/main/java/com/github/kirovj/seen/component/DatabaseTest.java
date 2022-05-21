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
        var v1 = new Video().name("testMovie").type(Type.Movie);
        var v2 = new Video().name("testSeries").type(Type.Series);
        videoService.save(v1);
        videoService.save(v2);
    }

    private void initTags() {
        var t1 = new Tag().name("惊悚");
        var t2 = new Tag().name("科幻");
        tagService.save(t1);;
        tagService.save(t2);
    }
}

package com.github.kirovj.seen.service.component;

import com.github.kirovj.seen.domain.enums.VideoType;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.dao.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : kirovj
 * @date : 2021/10/11 1:17
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final VideoRepository repository;

    public DatabaseLoader(VideoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        var v1 = new Video();
        var v2 = new Video();

        v1.setName("testMovie");
        v1.setType(VideoType.Movie);
        v2.setName("testSeries");
        v2.setType(VideoType.Series);
        repository.save(v1);
        repository.save(v2);
//        this.repository.save(Video.builder().name("testMovie").type(VideoType.Movie).build());
//        this.repository.save(Video.builder().name("testSeries").type(VideoType.Series).build());
    }
}
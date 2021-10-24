package com.github.kirovj.seen.component;

import com.github.kirovj.seen.domain.enums.Type;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.VideoRepository;
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
        var v1 = Video.builder().name("testMovie").type(Type.Movie);
        var v2 = Video.builder().name("testSeries").type(Type.Series);
        repository.save(v1);
        repository.save(v2);
//        this.repository.save(Video.builder().name("testMovie").type(VideoType.Movie).build());
//        this.repository.save(Video.builder().name("testSeries").type(VideoType.Series).build());
    }
}
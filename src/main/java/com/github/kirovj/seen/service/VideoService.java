package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.entity.Searcher;
import com.github.kirovj.seen.domain.modal.Video;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : kirovj
 * @date : 2021/10/25 1:16
 */
@Service
public class VideoService {

    private final VideoRepository videoRepository;


    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> find(Searcher searcher) {
        // todo
        return null;
    }

    public List<Video> findAll() {
        return videoRepository.findAllByValid(true);
    }

    public List<Video> findAllByName(String name) {
        return videoRepository.findAllByNameContainsIgnoreCase(name);
    }

    public Video findById(int id) {
        return videoRepository.findById(id).orElse(null);
    }

    public void save(Video video) {
        videoRepository.save(video);
    }
}

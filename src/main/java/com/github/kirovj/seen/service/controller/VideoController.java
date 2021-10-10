package com.github.kirovj.seen.service.controller;

import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.dao.VideoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author : kirovj
 * @date : 2021/10/11 1:13
 */
@RestController
public class VideoController {

    private final VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/videos")
    public List<Video> list() {
        return videoRepository.findAll();
    }

    @GetMapping("/video1")
    public Video get() {
        Optional<Video> optionalVideo = videoRepository.findById(1L);
        return optionalVideo.orElse(null);
    }
}

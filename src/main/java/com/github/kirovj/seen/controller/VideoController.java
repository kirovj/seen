package com.github.kirovj.seen.controller;

import com.github.kirovj.seen.domain.entity.Searcher;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : kirovj
 * @date : 2021/10/11 1:13
 */
@RestController
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/list")
    public List<Video> list(@RequestBody Searcher searcher) {
        return videoService.find(searcher);
    }

    @GetMapping("/all")
    public List<Video> listAll() {
        return videoService.findAll();
    }

    @GetMapping("/video1")
    public Video get() {
        return videoService.findById(1L);
    }
}

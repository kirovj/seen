package com.github.kirovj.seen.controller;

import com.github.kirovj.seen.domain.entity.Searcher;
import com.github.kirovj.seen.domain.enums.CrudStatus;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.VideoService;
import com.github.kirovj.seen.utils.Tuple;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : kirovj
 * @date : 2021/10/11 1:13
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/search")
    public List<Video> list(@RequestBody Searcher searcher) {
        return videoService.find(searcher);
    }

    @GetMapping("/all")
    public List<Video> listAll() {
        return videoService.findAll();
    }

    @GetMapping("/findByName")
    public List<Video> listByName(@RequestParam(value = "name") String name) {
        return videoService.findAllByName(name);
    }

    @PostMapping("/add")
    public Tuple<CrudStatus, Video> add(@RequestBody Video video){
        return videoService.add(video);
    }
}

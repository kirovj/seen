package com.github.kirovj.seen.controller;

import com.github.kirovj.seen.domain.entity.CrudResult;
import com.github.kirovj.seen.domain.entity.Searcher;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : kirovj
 * @date : 2021/10/11 1:13
 */
@Controller
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

    @GetMapping("/findByName")
    public String listByName(Model model, @RequestParam(value = "name") String name) {
        CrudResult<Video> result = videoService.findAllByName(name);
        model.addAttribute("result", result);
        return "index";
    }

    @PostMapping("/add")
    public String add(Model model, @RequestBody Video video) {
        CrudResult<Video> result = videoService.add(video);
        model.addAttribute("result", result);
        return "index";
    }
}

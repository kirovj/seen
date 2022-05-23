package com.github.kirovj.seen.controller;

import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public String index(Model model) {
        List<Video> videoList = videoService.findAll();
        model.addAttribute("videoList", videoList);
        return "index";
    }
}

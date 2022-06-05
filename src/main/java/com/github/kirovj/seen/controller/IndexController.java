package com.github.kirovj.seen.controller;

import com.github.kirovj.seen.domain.entity.CrudResult;
import com.github.kirovj.seen.domain.modal.Tag;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.service.TagService;
import com.github.kirovj.seen.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private TagService tagService;

    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public String index(Model model) {
        CrudResult<Video> result = videoService.findAll();
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/tags")
    public String tags(Model model) {
        CrudResult<Tag> result = tagService.findAll();
        model.addAttribute("result", result);
        return "tags";
    }
}

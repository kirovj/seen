package com.github.kirovj.seen.controller;

import com.github.kirovj.seen.domain.modal.Tag;
import com.github.kirovj.seen.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : kirovj
 * @date : 2022/2/1 23:21
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/all")
    public List<Tag> all() {
        return tagService.findAll();
    }

    @PostMapping("/add")
    public Tag add(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PostMapping("/delete")
    public Tag delete(@RequestBody Tag tag) {
        return tagService.delete(tag);
    }
}

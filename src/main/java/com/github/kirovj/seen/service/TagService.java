package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.modal.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : kirovj
 * @date : 2022/2/1 22:57
 */
@Service
public class TagService {

    private final TagRepository repository;

    public TagService(TagRepository tagRepository) {
        this.repository = tagRepository;
    }

    public void save(Tag tag) {
        repository.save(tag);
    }

    public List<Tag> findAll() {
        return repository.findAll();
    }
}

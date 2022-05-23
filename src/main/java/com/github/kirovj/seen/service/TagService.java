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

    public Tag findByName(String name) {
        return repository.findByName(name);
    }

    public Tag save(Tag tag) {
        return findByName(tag.getName()) == null ? repository.save(tag) : tag;
    }

    public Tag delete(Tag tag) {
        repository.delete(tag);
        return tag;
    }

    public List<Tag> findAll() {
        return repository.findAll();
    }
}

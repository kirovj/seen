package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.entity.CrudResult;
import com.github.kirovj.seen.domain.enums.CrudStatus;
import com.github.kirovj.seen.domain.modal.Tag;
import org.springframework.stereotype.Service;

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

    public CrudResult<Tag> findByName(String name) {
        return CrudResult.ok(repository.findByName(name));
    }

    public CrudResult<Tag> add(Tag tag) {
        return findByName(tag.getName()).getData() == null
                ? CrudResult.ok(repository.save(tag))
                : CrudResult.fail(CrudStatus.Exists);
    }

    public CrudResult<Tag> delete(Tag tag) {
        repository.delete(tag);
        return CrudResult.ok(tag);
    }

    public CrudResult<Tag> findAll() {
        return CrudResult.ok(repository.findAll());
    }
}

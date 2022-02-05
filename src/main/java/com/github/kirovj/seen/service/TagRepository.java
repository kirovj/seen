package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.modal.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : kirovj
 * @date : 2022/2/1 22:50
 */
interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByName(String name);
}
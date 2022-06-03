package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.modal.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author : kirovj
 * @date : 2021/10/10 17:28
 */
interface VideoRepository extends JpaRepository<Video, Integer> {

    List<Video> findAllByValid(boolean valid);

    List<Video> findAllByNameContainsIgnoreCase(String name);
}

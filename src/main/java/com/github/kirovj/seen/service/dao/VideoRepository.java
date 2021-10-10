package com.github.kirovj.seen.service.dao;

import com.github.kirovj.seen.domain.modal.Video;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author : kirovj
 * @date : 2021/10/10 17:28
 */
public interface VideoRepository extends PagingAndSortingRepository<Video, Long> {

    List<Video> findAll();

    @Override
    Optional<Video> findById(Long id);
}

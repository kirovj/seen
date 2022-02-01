package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.modal.Video;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/**
 * @author : kirovj
 * @date : 2021/10/10 17:28
 */
interface VideoRepository extends PagingAndSortingRepository<Video, Integer> {

    List<Video> findAllByValid(boolean valid);

}

package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.entity.CrudResult;
import com.github.kirovj.seen.domain.entity.Searcher;
import com.github.kirovj.seen.domain.enums.CrudStatus;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * @author : kirovj
 * @date : 2021/10/25 1:16
 */
@Service
public class VideoService {

    private final VideoRepository videoRepository;


    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> find(Searcher searcher) {
        // todo
        return null;
    }

    public CrudResult<Video> findAll() {
        return CrudResult.ok(videoRepository.findAllByValid(true));
    }

    public Video findByName(String name) {
        return videoRepository.findOneByName(name).orElse(null);
    }

    public CrudResult<Video> findAllByName(String name) {
        List<Video> videoList;
        // Optimised for jav code
        Matcher matcher = Constants.LETTER_NUMBER.matcher(name);
        if (matcher.matches()) {
            String prefix = matcher.group(1);
            String number = matcher.group(2).replaceFirst("^0*", "");
            videoList = videoRepository.findAllByNameContainsIgnoreCase(prefix)
                    .stream()
                    .filter(v -> v.getName().contains(number))
                    .collect(Collectors.toList());
        } else {
            videoList = videoRepository.findAllByNameContainsIgnoreCase(name);
        }
        return CrudResult.ok(videoList);
    }

    public Video findById(int id) {
        return videoRepository.findById(id).orElse(null);
    }

    public boolean checkValid(Video video) {
        return StringUtils.hasLength(video.getName()) && video.getType() != null;
    }

    public CrudResult<Video> add(Video video) {
        CrudStatus status;
        if (checkValid(video)) {
            if (findByName(video.getName()) != null) {
                status = CrudStatus.Empty;
            } else {
                video = videoRepository.save(video);
                status = CrudStatus.Success;
            }
        } else {
            status = CrudStatus.Invalid;
        }
        return CrudResult.of(status, video);
    }

    public CrudStatus update(Video video) {
        // todo
        return CrudStatus.Invalid;
    }
}

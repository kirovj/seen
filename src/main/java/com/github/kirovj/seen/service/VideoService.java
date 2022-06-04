package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.entity.Searcher;
import com.github.kirovj.seen.domain.enums.CrudStatus;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.utils.Constants;
import com.github.kirovj.seen.utils.Tuple;
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

    public List<Video> findAll() {
        return videoRepository.findAllByValid(true);
    }

    public Video findByName(String name) {
        return videoRepository.findOneByName(name).orElse(null);
    }

    public List<Video> findAllByName(String name) {
        // Optimised for jav code
        Matcher matcher = Constants.LETTER_NUMBER.matcher(name);
        if (matcher.matches()) {
            String prefix = matcher.group(1);
            String number = matcher.group(2).replaceFirst("^0*", "");
            return videoRepository.findAllByNameContainsIgnoreCase(prefix)
                    .stream()
                    .filter(v -> v.getName().contains(number))
                    .collect(Collectors.toList());
        }
        return videoRepository.findAllByNameContainsIgnoreCase(name);
    }

    public Video findById(int id) {
        return videoRepository.findById(id).orElse(null);
    }

    public void save(Video video) {
        videoRepository.save(video);
    }

    public boolean checkValid(Video video) {
        return StringUtils.hasLength(video.getName()) && video.getType() != null;
    }

    public Tuple<CrudStatus, Video> add(Video video) {
        CrudStatus status;
        if (checkValid(video)) {
            if (findByName(video.getName()) != null) {
                status = CrudStatus.Exists;
            } else {
                video = videoRepository.save(video);
                status = CrudStatus.Success;
            }
        } else {
            status = CrudStatus.Invalid;
        }
        return Tuple.of(status, video);
    }

    public CrudStatus update(Video video) {
        // todo
        return CrudStatus.Invalid;
    }
}

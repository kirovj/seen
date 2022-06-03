package com.github.kirovj.seen.service;

import com.github.kirovj.seen.domain.entity.Searcher;
import com.github.kirovj.seen.domain.modal.Video;
import com.github.kirovj.seen.utils.Constants;
import org.springframework.stereotype.Service;

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

    public List<Video> findAllByName(String name) {
        List<Video> videos;
        // Optimised for jav code
        Matcher matcher = Constants.LETTER_NUMBER.matcher(name);
        if (matcher.matches()) {
            String prefix = matcher.group(1);
            String number = matcher.group(2).replaceFirst("^0*", "");
            videos = videoRepository.findAllByNameContainsIgnoreCase(prefix)
                    .stream()
                    .filter(v -> v.getName().contains(number))
                    .collect(Collectors.toList());
            return videos;
        }
        return videoRepository.findAllByNameContainsIgnoreCase(name);
    }

    public Video findById(int id) {
        return videoRepository.findById(id).orElse(null);
    }

    public void save(Video video) {
        videoRepository.save(video);
    }
}

package com.rss.keshava.service;

import com.rss.keshava.domain.ImageFile;
import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.Video;
import com.rss.keshava.repo.VideoRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public Status create(Video video) {
        Video byUid = videoRepository.findByUid(video.getDescription());
        if (byUid != null) {
            return new Status(Constants.FAILED, "Video already exists");
        }
        long time = new Date().getTime();
        video.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
        video.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars
        video.setName(video.getName());
        video.setDescription(video.getDescription());
        video.setUrl(video.getUrl());

        videoRepository.save(video);
        return new Status(Constants.SUCCESS, "Video saved", video.getId(), video);
    }

    public Status update(Video video) {
        Video videoByUid = videoRepository.findByUid(video.getUid());

        if (videoByUid != null) {
            long time = new Date().getTime();
            videoByUid.setName(video.getName());
            videoByUid.setDescription(video.getDescription());
            videoByUid.setUrl(video.getUrl());
            videoByUid.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));

            videoRepository.save(videoByUid);
        } else {
            return new Status(Constants.FAILED, "Video not exists");
        }

        return new Status(Constants.SUCCESS, "Video updated", videoByUid.getId(), videoByUid);
    }

    public Iterable<Video> getAll() {
        return videoRepository.findAll();
    }

    public Status delete(String uid) {
        Video videoByUid = videoRepository.findByUid(uid);
        if (videoByUid != null) {
            videoRepository.delete(videoByUid);
        } else {
            return new Status(Constants.FAILED, "Video not exists");
        }
        return new Status(Constants.SUCCESS, "Video deleted");
    }
}

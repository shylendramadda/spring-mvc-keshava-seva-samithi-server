package com.rss.keshava.controller;

import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.Video;
import com.rss.keshava.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping
    public Status create(@RequestBody Video video) {
        return videoService.create(video);
    }

    @PutMapping
    public Status update(@Valid @RequestBody Video video) {
        return videoService.update(video);
    }

    @GetMapping("/")
    public Iterable<Video> getAll() {
        return videoService.getAll();
    }

    @DeleteMapping(value = "/{uid}")
    public Status delete(@PathVariable String uid) {
        return videoService.delete(uid);
    }


}

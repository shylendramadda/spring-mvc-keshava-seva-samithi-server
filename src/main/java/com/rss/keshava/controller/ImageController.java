package com.rss.keshava.controller;

import com.rss.keshava.domain.ImageFile;
import com.rss.keshava.domain.Status;
import com.rss.keshava.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public Status upload(@RequestParam("file") MultipartFile file){
        return imageService.upload(file);
    }

    @GetMapping("/getAll")
    public Iterable<ImageFile> getAll(){
        return imageService.getAll();
    }
}

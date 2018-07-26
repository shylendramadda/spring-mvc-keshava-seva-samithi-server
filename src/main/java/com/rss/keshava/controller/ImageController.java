package com.rss.keshava.controller;

import com.rss.keshava.domain.ImageFile;
import com.rss.keshava.domain.Status;
import com.rss.keshava.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public Status upload(@RequestParam("file") MultipartFile file, @RequestParam("description") String description){
        return imageService.upload(file, description);
    }

    @GetMapping("/getAll")
    public List<ImageFile> getAllGalleryImages(){
        return imageService.getAllGalleryImages();
    }

    @DeleteMapping(value = "/{uid}")
    public Status delete(@PathVariable String uid){
        return imageService.delete(uid);
    }
}

package com.rss.keshava.service;

import com.rss.keshava.domain.ImageFile;
import com.rss.keshava.domain.Status;
import com.rss.keshava.repo.ImageRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    private final Path rootLocation = Paths.get("upload_dir");

    public Status upload(MultipartFile file, String description) {
        try {
            long time = new Date().getTime();

            if (!Files.isDirectory(Paths.get("upload_dir"))) {
                Files.createDirectory(rootLocation);
            }
            String originalFilename = file.getOriginalFilename();
            String uniqueFileName = time + "_" + originalFilename;

            Files.copy(file.getInputStream(), this.rootLocation.resolve(uniqueFileName));

            ImageFile imageFile = new ImageFile();

            imageFile.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars
            imageFile.setCreateTime(time);
            imageFile.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            imageFile.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            imageFile.setUpdateTime(time);

            imageFile.setName(originalFilename);
            imageFile.setDescription(description);
            imageFile.setFilePath("http://localhost:8080/" + this.rootLocation.getFileName() + "/" + uniqueFileName);

            imageRepository.save(imageFile);
            return new Status(Constants.SUCCESS, "File uploaded successfully", imageFile.getId(), imageFile);

        } catch (Exception e) {
            return new Status(Constants.FAILED, "Failed to upload file", 0l, null);
        }
    }

    public Iterable<ImageFile> getAll() {
        return imageRepository.findAll();
    }

    public Status delete(String uid) {
        ImageFile imageByUid = imageRepository.findByUid(uid);

        if (imageByUid != null) {
            imageRepository.delete(imageByUid);
        } else {
            return new Status(Constants.FAILED, "Image not exists");
        }
        return new Status(Constants.SUCCESS, "Image deleted");
    }
}

package com.rss.keshava.service;

import com.rss.keshava.domain.CommitteeMember;
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
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CommitteeMemberService committeeMemberService;

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

    public Status uploadUserImage(MultipartFile file, String uid, String from) {
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
            imageFile.setUserUid(uid);

            imageFile.setFilePath("http://localhost:8080/" + this.rootLocation.getFileName() + "/" + uniqueFileName);

            imageRepository.save(imageFile);

            switch (from) {
                case "member": {
                    CommitteeMember memberByUuid = committeeMemberService.getByUuid(uid);
                    if (memberByUuid != null) {
                        memberByUuid.setPhoto(imageFile.getFilePath());
                        committeeMemberService.update(memberByUuid);
                    }
                    break;
                }

                // TODO for student we need to pass student from it's controller and save it here
            }

            return new Status(Constants.SUCCESS, "File uploaded successfully", imageFile.getId(), imageFile);

        } catch (Exception e) {
            return new Status(Constants.FAILED, "Failed to upload file", 0l, null);
        }
    }

    public List<ImageFile> getAllGalleryImages() {
        List<ImageFile> allImages = (List<ImageFile>) imageRepository.findAll();
        return  allImages.stream().parallel().filter(i -> i.getUserUid() == null).collect(Collectors.toList());
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

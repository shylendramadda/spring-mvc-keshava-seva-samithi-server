package com.rss.keshava.controller;

import com.rss.keshava.domain.CommitteeMember;
import com.rss.keshava.domain.Status;
import com.rss.keshava.service.CommitteeMemberService;
import com.rss.keshava.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/committeeMember")
public class CommitteeMemberController {
    @Autowired
    private CommitteeMemberService committeeMemberService;
    @Autowired
    private ImageService imageService;

    @PostMapping
    public Status create(@RequestBody CommitteeMember committeeMember) {
        return committeeMemberService.create(committeeMember);
    }

    @PutMapping
    public Status update(@Valid @RequestBody CommitteeMember committeeMember) {
        return committeeMemberService.update(committeeMember);
    }

    @GetMapping("/")
    public Iterable<CommitteeMember> getAll() {
        return committeeMemberService.getAll();
    }

    @GetMapping(value = "/{uid}")
    public CommitteeMember get(@PathVariable String uuid) {
        return committeeMemberService.getByUuid(uuid);
    }

    @DeleteMapping(value = "/{uid}")
    public Status delete(@PathVariable String uid) {
        return committeeMemberService.delete(uid);
    }

    @PostMapping("/upload")
    public Status upload(@RequestParam("file") MultipartFile file, @RequestParam("memberId") String memberId){
        return imageService.uploadUserImage(file, memberId, "member");
    }
}


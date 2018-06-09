package com.rss.keshava.controller;

import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.User;
import com.rss.keshava.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/donor")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping
    public Status create(@RequestBody Donor donor) {
        return donorService.create(donor);
    }

    @PutMapping("/{uid}")
    public Status update(@Valid @RequestBody Donor donor) {
        return donorService.update(donor);
    }

    @GetMapping("/")
    public Iterable<Donor> getAll() {
        return donorService.getAll();
    }

}

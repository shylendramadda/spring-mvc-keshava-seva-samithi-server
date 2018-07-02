package com.rss.keshava.controller;

import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Status;
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

    @PutMapping
    public Status update(@Valid @RequestBody Donor donor) {
        return donorService.update(donor);
    }

    @GetMapping("/")
    public Iterable<Donor> getAll() {
        return donorService.getAll();
    }

    @GetMapping("/search/{inputString}")
    public Iterable<Donor> getDonorsByInput(@PathVariable String inputString) {
        return donorService.getDonorsByInput(inputString);
    }

    @GetMapping(value = "/{uid}")
    public Donor get(@PathVariable String uuid) {
        return donorService.getByUuid(uuid);
    }

    @DeleteMapping(value = "/{uid}")
    public Status delete(@PathVariable String uid) {
        return donorService.delete(uid);
    }

}

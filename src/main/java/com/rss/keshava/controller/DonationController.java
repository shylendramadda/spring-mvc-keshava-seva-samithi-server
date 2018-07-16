package com.rss.keshava.controller;

import com.rss.keshava.domain.Donation;
import com.rss.keshava.domain.Status;
import com.rss.keshava.repo.DonationRepository;
import com.rss.keshava.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @Autowired
    private DonationRepository donationRepository;

    @PostMapping
    public Status create(@RequestBody Donation donation) {
        return donationService.save(donation);
    }

    /*@PutMapping
    public Status update(@RequestBody Donation donation){
        return donationService.update(donation);
    }*/

    @GetMapping(value = "/{uid}")
    public Iterable<Donation> getAllByUid(@PathVariable String uid){
        return donationService.getAll(uid);
    }

}

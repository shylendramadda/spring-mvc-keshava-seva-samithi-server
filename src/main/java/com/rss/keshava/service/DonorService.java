package com.rss.keshava.service;

import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Status;
import com.rss.keshava.repo.DonorRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class DonorService {

    @Autowired
    DonorRepository donorRepository;

    public Status create(Donor donor) {
        Donor dbUser = donorRepository.findByEmailOrMobile(donor.getEmail(), donor.getMobile());
        if (dbUser != null) {
            return new Status(Constants.FAILED, "Donor already exists");
        }
        long time = new Date().getTime();
        donor.setCreateTime(time);
        donor.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
        donor.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

        donor.setSurname(donor.getSurname());
        donor.setName(donor.getName());
        donor.setMobile(donor.getMobile());
        donor.setEmail(donor.getEmail());

        donorRepository.save(donor);

        return new Status(Constants.SUCCESS, "Donor created successfully", donor.getId(), donor);
    }
}

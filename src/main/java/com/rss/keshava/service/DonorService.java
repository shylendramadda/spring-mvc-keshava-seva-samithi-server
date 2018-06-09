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
        try {
            Donor dbUser = donorRepository.findByEmailOrMobile(donor.getEmail(), donor.getMobile());
            if (dbUser != null) {
                return new Status(Constants.FAILED, "Donor already exists");
            }
            long time = new Date().getTime();
            donor.setCreateTime(time);
            donor.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            donor.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

            donor.setSurname(donor.getSurname());
            donor.setLastName(donor.getLastName());
            donor.setMobile(donor.getMobile());
            donor.setEmail(donor.getEmail());

            donorRepository.save(donor);

            return new Status(Constants.SUCCESS, "Donor created successfully", donor.getId(), donor);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", donor.getId(), donor);
        }
    }

    public Status update(Donor donor) {
        try {
            Donor dbUser = donorRepository.findByEmailOrMobile(donor.getEmail(), donor.getMobile());
            if (dbUser != null) {
                long time = new Date().getTime();
                dbUser.setCreateTime(time);
                dbUser.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
                dbUser.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

                dbUser.setSurname(donor.getSurname());
                dbUser.setLastName(donor.getLastName());
                dbUser.setMobile(donor.getMobile());
                dbUser.setEmail(donor.getEmail());
                dbUser.setUpdateTime(time);
                dbUser.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));

                donorRepository.save(dbUser);
            } else {
                return new Status(Constants.FAILED, "Donor doesn't exist", donor.getId(), donor);
            }
            return new Status(Constants.SUCCESS, "Updated donor successfully", donor.getId(), donor);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", donor.getId(), donor);
        }
    }

    public Iterable<Donor> getAll() {
        return donorRepository.findAll();
    }
}

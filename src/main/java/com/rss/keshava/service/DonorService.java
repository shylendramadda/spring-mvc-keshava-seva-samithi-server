package com.rss.keshava.service;

import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.User;
import com.rss.keshava.repo.DonorRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class DonorService {

    @Autowired
    DonorRepository donorRepository;

    public Status create(Donor donor) {
        try {
            Donor dbUser = donorRepository.findByEmailOrMobileOrSurname(donor.getEmail(), donor.getMobile(), donor.getSurname());
            if (dbUser != null) {
                return new Status(Constants.FAILED, "Donor already exists", dbUser.getId(), dbUser);
            }
            long time = new Date().getTime();
            donor.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars
            donor.setCreateTime(time);
            donor.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            donor.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            donor.setUpdateTime(time);

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
                donor.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
                donor.setUpdateTime(time);

                donorRepository.save(donor);
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

    public Status delete(String uid) {
        Donor dbUser = donorRepository.findByUid(uid);
        if (dbUser != null) {
            donorRepository.delete(dbUser);
        } else {
            return new Status(Constants.FAILED, "Donor not exists");
        }
        return new Status(Constants.SUCCESS, "Donor deleted");
    }

    public Donor getByUuid(String uuid) {
        Donor dbUser = donorRepository.findByUid(uuid);
        if (dbUser != null) {
            return dbUser;
        }
        return null;
    }

    public Iterable<Donor> getDonorsByInput(String inputString) {
       return donorRepository.findByEmailIgnoreCaseContainingOrMobileIgnoreCaseContainingOrSurnameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(inputString, inputString, inputString, inputString);
    }
}

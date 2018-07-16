package com.rss.keshava.service;

import com.rss.keshava.domain.Donation;
import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Status;
import com.rss.keshava.repo.DonationRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class DonationService {

    @Autowired
    DonationRepository donationRepository;

    public Status save(Donation donation) {
        try {

            long time = new Date().getTime();
            donation.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars
            donation.setCreateTime(time);
            donation.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            donation.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            donation.setUpdateTime(time);

            donationRepository.save(donation);

            return new Status(Constants.SUCCESS, "Donation created successfully", donation.getId(), donation);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", donation.getId(), donation);
        }
    }

    public Iterable<Donation> getAll(String uid) {
        return donationRepository.findByDonorUid(uid);
    }

    /*public Status update(Donation donation) {
        try {
            Donation dbDonation = donationRepository.findByUid(donation.getUid());
            if (dbDonation != null) {
                long time = new Date().getTime();
                donation.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));

                donation.setUpdateTime(time);
                donationRepository.save(donation);
            } else {
                return new Status(Constants.FAILED, "Donation doesn't exist", donation.getId(), donation);
            }
            return new Status(Constants.SUCCESS, "Updated donor successfully", donation.getId(), donation);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", donation.getId(), donation);
        }
    }*/
}

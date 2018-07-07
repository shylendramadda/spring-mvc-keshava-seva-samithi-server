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
            donor.setAmount(donor.getAmount());
            donor.setAmountFor(donor.getAmountFor());
            donor.setCity(donor.getCity());
            donor.setCountry(donor.getCountry());
            donor.setDistrict(donor.getDistrict());
            donor.setEventDate(donor.getEventDate());
            donor.setEventOf(donor.getEventOf());
            donor.setHouseNo(donor.getHouseNo());
            donor.setLandMark(donor.getLandMark());
            donor.setMandal(donor.getMandal());
            donor.setPaymentType(donor.getPaymentType());
            donor.setPostOffice(donor.getPostOffice());
            donor.setState(donor.getState());
            donor.setStreet(donor.getStreet());

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
                dbUser.setState(donor.getState());
                dbUser.setPostOffice(donor.getPostOffice());
                dbUser.setPaymentType(donor.getPaymentType());
                dbUser.setMandal(donor.getMandal());
                dbUser.setLandMark(donor.getLandMark());
                dbUser.setHouseNo(donor.getHouseNo());
                dbUser.setEventOf(donor.getEventOf());
                dbUser.setDistrict(donor.getDistrict());
                dbUser.setEventDate(donor.getEventDate());
                dbUser.setCity(donor.getCity());
                dbUser.setStreet(donor.getStreet());
                dbUser.setCountry(donor.getCountry());
                dbUser.setAmount(donor.getAmount());
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
        Iterable<Donor> donorList;
        donorList = donorRepository.findByEmailOrMobileOrSurnameOrLastName(inputString, inputString, inputString, inputString);
        if (donorList != null) {
            for (Donor donor : donorList) {
                if (donor != null) {
                    ((ArrayList<Donor>) donorList).add(donor);
                }
            }
        }
        return donorList;
    }
}

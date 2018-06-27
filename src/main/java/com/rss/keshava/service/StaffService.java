package com.rss.keshava.service;

import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Staff;
import com.rss.keshava.domain.Status;
import com.rss.keshava.repo.StaffRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;
@Transactional
@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    public Status create(Staff staff) {
        try {
            Staff dbUser = staffRepository.findBysurName(staff.getSurName());
            if (dbUser != null) {
                return new Status(Constants.FAILED, "Staff already exists");
            }
            long time = new Date().getTime();
            staff.setCreateTime(time);
            staff.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            staff.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

            staff.setSurName(staff.getSurName());
            staff.setLastName(staff.getLastName());
            staff.setMobileNumber(staff.getMobileNumber());
            staff.setEmailId(staff.getEmailId());
            staff.setAddress(staff.getAddress());
            staff.setAdharNumber(staff.getAdharNumber());
            staff.setDesignation(staff.getDesignation());
            staff.setGender(staff.getGender());
            staff.setFromDate(staff.getFromDate());
            staff.setThruDate(staff.getThruDate());
            staff.setPhoto(staff.getPhoto());

            staffRepository.save(staff);

            return new Status(Constants.SUCCESS, "Staff created successfully", staff.getId(), staff);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", staff.getId(), staff);
        }
    }

    public Status update(Staff staff) {
        try {
            Staff dbUser = staffRepository.findBysurName(staff.getSurName());
            if (dbUser != null) {
                long time = new Date().getTime();
                dbUser.setCreateTime(time);
                dbUser.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
                dbUser.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

                dbUser.setSurName(dbUser.getSurName());
                dbUser.setLastName(dbUser.getLastName());
                dbUser.setMobileNumber(dbUser.getMobileNumber());
                dbUser.setEmailId(dbUser.getEmailId());
                dbUser.setAddress(dbUser.getAddress());
                dbUser.setAdharNumber(dbUser.getAdharNumber());
                dbUser.setDesignation(dbUser.getDesignation());
                dbUser.setGender(dbUser.getGender());
                dbUser.setFromDate(dbUser.getFromDate());
                dbUser.setThruDate(dbUser.getThruDate());
                dbUser.setPhoto(dbUser.getPhoto());

                dbUser.setUpdateTime(time);
                dbUser.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));

                staffRepository.save(dbUser);
            } else {
                return new Status(Constants.FAILED, "Staff doesn't exist", staff.getId(), staff);
            }
            return new Status(Constants.SUCCESS, "Updated staff successfully", staff.getId(), staff);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", staff.getId(), staff);
        }
    }

    public Iterable<Staff> getAll() {
        return staffRepository.findAll();
    }

    public Status delete(String uid) {
        Staff dbUser = staffRepository.findByUid(uid);
        if (dbUser != null) {
            staffRepository.delete(dbUser);
        } else {
            return new Status(Constants.FAILED, "Staff not exists");
        }
        return new Status(Constants.SUCCESS, "Staff deleted");
    }

    public Staff getByUuid(String uuid) {
        Staff dbUser = staffRepository.findByUid(uuid);
        if (dbUser != null) {
            return  dbUser;
        }
        return null;
    }
}

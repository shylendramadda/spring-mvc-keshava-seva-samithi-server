package com.rss.keshava.service;

import com.rss.keshava.domain.CommitteeMember;
import com.rss.keshava.domain.Staff;
import com.rss.keshava.domain.Status;
import com.rss.keshava.repo.CommitteeMemberRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;
@Transactional
@Service
public class CommitteeMemberService {
    @Autowired
    CommitteeMemberRepository committeeMemberRepository;

    public Status create(CommitteeMember committeeMember) {
        try {
            CommitteeMember dbUser = committeeMemberRepository.findBysurName(committeeMember.getSurName());
            if (dbUser != null) {
                return new Status(Constants.FAILED, "Committee Member already exists");
            }
            long time = new Date().getTime();
            committeeMember.setCreateTime(time);
            committeeMember.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            committeeMember.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

            committeeMember.setSurName(committeeMember.getSurName());
            committeeMember.setLastName(committeeMember.getLastName());
            committeeMember.setMobileNumber(committeeMember.getMobileNumber());
            committeeMember.setEmailId(committeeMember.getEmailId());
            committeeMember.setAddress(committeeMember.getAddress());
            committeeMember.setAdharNumber(committeeMember.getAdharNumber());
            committeeMember.setDesignation(committeeMember.getDesignation());
            committeeMember.setGender(committeeMember.getGender());
            committeeMember.setFromDate(committeeMember.getFromDate());
            committeeMember.setThruDate(committeeMember.getThruDate());
            committeeMember.setPhoto(committeeMember.getPhoto());

            committeeMemberRepository.save(committeeMember);

            return new Status(Constants.SUCCESS, "Committee Member created successfully", committeeMember.getId(), committeeMember);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", committeeMember.getId(), committeeMember);
        }
    }

    public Status update(CommitteeMember committeeMember) {
        try {
            CommitteeMember dbUser = committeeMemberRepository.findBysurName(committeeMember.getSurName());
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

                committeeMemberRepository.save(dbUser);
            } else {
                return new Status(Constants.FAILED, "Committee Member doesn't exist", committeeMember.getId(), committeeMember);
            }
            return new Status(Constants.SUCCESS, "Updated Committee Member successfully", committeeMember.getId(), committeeMember);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", committeeMember.getId(), committeeMember);
        }
    }

    public Iterable<CommitteeMember> getAll() {
        return committeeMemberRepository.findAll();
    }

    public Status delete(String uid) {
        CommitteeMember dbUser = committeeMemberRepository.findByUid(uid);
        if (dbUser != null) {
            committeeMemberRepository.delete(dbUser);
        } else {
            return new Status(Constants.FAILED, "Committee Member not exists");
        }
        return new Status(Constants.SUCCESS, "Committee Member deleted");
    }

    public CommitteeMember getByUuid(String uuid) {
        CommitteeMember dbUser = committeeMemberRepository.findByUid(uuid);
        if (dbUser != null) {
            return  dbUser;
        }
        return null;
    }
}


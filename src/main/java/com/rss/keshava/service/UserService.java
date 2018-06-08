package com.rss.keshava.service;

import com.rss.keshava.domain.Role;
import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.User;
import com.rss.keshava.repo.UserRepository;
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
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Status create(User user) {
        User dbUser = userRepository.findByEmailOrMobile(user.getEmail(), user.getMobile());
        if (dbUser != null) {
            return new Status(Constants.FAILED, "User already exists");
        }
        long time = new Date().getTime();
        user.setCreateTime(time);
        String roles = Role.USER.name() + "," + Role.COMMITTEE_MEMBER.name();
        user.setRoles(roles);
        user.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
        user.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars
        userRepository.save(user);

        return new Status(Constants.SUCCESS, "User created", user.getId(), user);
    }

    public Status update(User user) {
        User dbUser = userRepository.findByEmailOrMobile(user.getEmail(), user.getMobile());
        if (dbUser != null) {
            long time = new Date().getTime();
            dbUser.setName(user.getName());
            dbUser.setEmail(user.getEmail());
            dbUser.setMobile(user.getMobile());
            dbUser.setUserName(user.getUserName());
            dbUser.setPassword(user.getPassword());
            dbUser.setUpdateTime(time);
            dbUser.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            userRepository.save(dbUser);
        } else {
            return new Status(Constants.FAILED, "User not exists");
        }

        return new Status(Constants.SUCCESS, "User updated", dbUser.getId(), dbUser);
    }

    public Status delete(String uuid) {
        User dbUser = userRepository.findByUid(uuid);
        if (dbUser != null) {
            userRepository.delete(dbUser);
        } else {
            return new Status(Constants.FAILED, "User not exists");
        }
        return new Status(Constants.SUCCESS, "User deleted");
    }

    public User getByUid(String uid) {
        return userRepository.findByUid(uid);
    }

    public Iterable<User> getAll(String roles) {
        if (roles.contains(Role.ADMIN.name())) {
            return userRepository.findAll();
        }
        return new ArrayList<>();
    }

    public User login(User user) {
        User byUserNameAndPassword = userRepository.findByUserNameAndPassword(user.getEmail(), user.getPassword());
        return byUserNameAndPassword;
    }

    public User getByUserName(String userName) {
        return userRepository.findByEmailOrMobile(userName, userName);
    }
}

package com.rss.keshava.repo;

import com.rss.keshava.domain.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {

    Staff findBysurName(String surName);

    Staff findByUid(String uuid);
}

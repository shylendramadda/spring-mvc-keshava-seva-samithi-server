package com.rss.keshava.repo;

import com.rss.keshava.domain.CommitteeMember;
import com.rss.keshava.domain.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitteeMemberRepository extends CrudRepository<CommitteeMember, Long> {

    CommitteeMember findByEmailOrMobileOrSurName(String email, String mobile, String surName);

    CommitteeMember findByUid(String uuid);
}

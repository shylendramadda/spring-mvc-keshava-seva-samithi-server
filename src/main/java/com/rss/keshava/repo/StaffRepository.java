package com.rss.keshava.repo;

import com.rss.keshava.domain.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {

    Staff findBySurname(String surname);

    Staff findByUid(String uuid);
}

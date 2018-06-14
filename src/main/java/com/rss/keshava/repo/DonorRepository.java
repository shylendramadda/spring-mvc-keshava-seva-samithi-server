package com.rss.keshava.repo;

import com.rss.keshava.domain.Donor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<Donor, Long> {

    Donor findByEmailOrMobile(String email, String mobile);

    Donor findByUid(String uuid);
}

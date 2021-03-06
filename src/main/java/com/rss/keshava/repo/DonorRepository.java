package com.rss.keshava.repo;

import com.rss.keshava.domain.Donor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends CrudRepository<Donor, Long> {

    Donor findByEmailOrMobile(String email, String mobile);

    Donor findByUid(String uuid);

    Donor findByEmailOrMobileOrSurname(String email, String mobile, String surname);

    List<Donor> findByEmailIgnoreCaseContainingOrMobileIgnoreCaseContainingOrSurnameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(String email, String mobile, String surname, String lastName);
}

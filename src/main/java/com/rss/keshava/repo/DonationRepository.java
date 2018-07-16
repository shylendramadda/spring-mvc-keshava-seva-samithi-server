package com.rss.keshava.repo;

import com.rss.keshava.domain.Donation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DonationRepository extends CrudRepository<Donation, Long> {

    List<Donation> findByDonorUid(String uid);
}

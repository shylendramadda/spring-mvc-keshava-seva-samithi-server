package com.rss.keshava.repo;

import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.ImageFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<ImageFile, Long> {

    Donor findByUid(String uuid);
}

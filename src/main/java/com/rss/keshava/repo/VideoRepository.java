package com.rss.keshava.repo;

import com.rss.keshava.domain.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {

    Video findByUid(String uid);
}

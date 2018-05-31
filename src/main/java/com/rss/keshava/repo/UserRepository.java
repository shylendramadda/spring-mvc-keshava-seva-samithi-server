package com.rss.keshava.repo;

import com.rss.keshava.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailOrMobile(String email, String mobile);

    User findByUid(String uuid);

    User findByUserNameAndPassword(String userName, String password);
}

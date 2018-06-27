package com.rss.keshava.repo;

import com.rss.keshava.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    Student findBySnameOrAdmissionNumber(String sname,int admissionNumber);

    Student findByUid(String uuid);
}

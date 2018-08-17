package com.rss.keshava.repo;

import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    Student findBySnameOrAdmissionNumber(String sname,String admissionNumber);
    Student findByUid(String uuid);
    List<Student> findBySnameIgnoreCaseContainingOrAdmissionNumberIgnoreCaseContaining(String sname, String admissionNumber);
}

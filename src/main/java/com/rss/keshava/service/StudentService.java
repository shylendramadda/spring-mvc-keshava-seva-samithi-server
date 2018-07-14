package com.rss.keshava.service;
import com.rss.keshava.domain.Status;
import com.rss.keshava.domain.Student;
import com.rss.keshava.repo.StudentRepository;
import com.rss.keshava.utils.Constants;
import com.rss.keshava.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Status create(Student student) {
        try {
            Student dbUser = studentRepository.findBySnameOrAdmissionNumber(student.getSname(), student.getAdmissionNumber());
            if (dbUser != null) {
                return new Status(Constants.FAILED, "Student already exists");
            }
            long time = new Date().getTime();
            student.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars
            student.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            student.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            student.setCreateTime(time);
            student.setUpdateTime(time);

            studentRepository.save(student);

            return new Status(Constants.SUCCESS, "Student created successfully", student.getId(), student);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", student.getId(), student);
        }
    }

    public Status update(Student student) {
        try {
            Student dbUser = studentRepository.findBySnameOrAdmissionNumber(student.getSname(), student.getAdmissionNumber());
            if (dbUser != null) {
                long time = new Date().getTime();
                student.setUpdateTime(time);
                student.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));

                studentRepository.save(student);
            } else {
                return new Status(Constants.FAILED, "Student doesn't exist", student.getId(), student);
            }
            return new Status(Constants.SUCCESS, "Updated Student successfully", student.getId(), student);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(Constants.SEVER_ERROR, "Problem occurred try again", student.getId(), student);
        }
    }

    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    public Status delete(String uid) {
        Student dbUser = studentRepository.findByUid(uid);
        if (dbUser != null) {
            studentRepository.delete(dbUser);
        } else {
            return new Status(Constants.FAILED, "Student not exists");
        }
        return new Status(Constants.SUCCESS, "student deleted");
    }

    public Student getByUuid(String uuid) {
        Student dbUser = studentRepository.findByUid(uuid);
        if (dbUser != null) {
            return  dbUser;
        }
        return null;
    }
}

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
            student.setCreateTime(time);
            student.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
            student.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

            student.setSname(student.getSname());
            student.setAdmissionNumber(student.getAdmissionNumber());
            student.setAge(student.getAge());
            student.setDateOfBirth(student.getDateOfBirth());
            student.setGender(student.getGender());
            student.setOrphan(student.getOrphan());
            student.setEducation(student.getEducation());
            student.setSchoolAddress(student.getSchoolAddress());
            student.setAdharNumber(student.getAdharNumber());
            student.setMobileNumber(student.getMobileNumber());
            student.setPresentAddress(student.getPresentAddress());
            student.setPermanentAddress(student.getPermanentAddress());
            student.setMotherName(student.getMotherName());
            student.setFatherName(student.getFatherName());
            student.setMotherAdharNumber(student.getMotherAdharNumber());
            student.setMotherOccupation(student.getMotherOccupation());
            student.setFatherAdharNumber(student.getFatherOccupation());
            student.setFatherOccupation(student.getFatherOccupation());
            student.setMotherDearthDate(student.getMotherDearthDate());
            student.setMotherPlaceOfDeath(student.getMotherPlaceOfDeath());
            student.setFatherDearthDate(student.getFatherDearthDate());
            student.setGaurdianName(student.getGaurdianName());
            student.setGaurdianAdharNumer(student.getGaurdianAdharNumer());
            student.setGaurdianOccupation(student.getGaurdianOccupation());
            student.setGaurdianMobileNumber(student.getGaurdianMobileNumber());
            student.setGaurdianEmailId(student.getGaurdianEmailId());
            student.setGaurdianPresentAddress(student.getGaurdianPresentAddress());
            student.setPermanentAddress(student.getPermanentAddress());
            student.setAttachments(student.getAttachments());
            student.setPhoto(student.getPhoto());

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
                dbUser.setCreateTime(time);
                dbUser.setCreatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));
                dbUser.setUid(UUID.randomUUID().toString()); // generates random UUID with 36 chars

                dbUser.setSname(student.getSname());
                dbUser.setAdmissionNumber(student.getAdmissionNumber());
                dbUser.setDateOfBirth(student.getDateOfBirth());
                dbUser.setAge(student.getAge());
                dbUser.setCaste(student.getCaste());
                dbUser.setOrphan(student.getOrphan());
                dbUser.setGender(student.getGender());
                dbUser.setEducation(student.getEducation());
                dbUser.setSchoolAddress(student.getSchoolAddress());
                dbUser.setAdharNumber(student.getAdharNumber());
                dbUser.setMobileNumber(student.getMobileNumber());
                dbUser.setPresentAddress(student.getPresentAddress());
                dbUser.setPermanentAddress(student.getPermanentAddress());
                dbUser.setMotherName(student.getFatherName());
                dbUser.setFatherName(student.getFatherName());
                dbUser.setMotherAdharNumber(student.getMotherAdharNumber());
                dbUser.setMotherOccupation(student.getMotherOccupation());
                dbUser.setFatherAdharNumber(student.getFatherAdharNumber());
                dbUser.setFatherOccupation(student.getFatherOccupation());
                dbUser.setMotherDearthDate(student.getMotherDearthDate());
                dbUser.setMotherPlaceOfDeath(student.getMotherPlaceOfDeath());
                dbUser.setFatherDearthDate(student.getFatherDearthDate());
                dbUser.setFatherPlaceOfDeath(student.getFatherPlaceOfDeath());
                dbUser.setGaurdianName(student.getGaurdianName());
                dbUser.setGaurdianAdharNumer(student.getGaurdianAdharNumer());
                dbUser.setMotherPlaceOfDeath(student.getMotherPlaceOfDeath());
                dbUser.setFatherDearthDate(student.getFatherDearthDate());
                dbUser.setFatherPlaceOfDeath(student.getFatherPlaceOfDeath());
                dbUser.setGaurdianName(student.getGaurdianName());
                dbUser.setGaurdianAdharNumer(student.getGaurdianAdharNumer());
                dbUser.setGaurdianOccupation(student.getGaurdianOccupation());
                dbUser.setGaurdianMobileNumber(student.getGaurdianMobileNumber());
                dbUser.setGaurdianEmailId(student.getGaurdianEmailId());
                dbUser.setGaurdianPresentAddress(student.getGaurdianPresentAddress());
                dbUser.setGaurdianPermanentAddress(student.getGaurdianPermanentAddress());
                dbUser.setAttachments(student.getAttachments());
                dbUser.setPhoto(student.getPhoto());
                dbUser.setUpdateTime(time);
                dbUser.setUpdatedOn(DateUtils.getDate1(time, DateUtils.DEFAULT_FORMAT));

                studentRepository.save(dbUser);
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

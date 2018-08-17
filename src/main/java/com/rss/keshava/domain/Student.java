package com.rss.keshava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String createdBy;
    private String updatedBy;
    private String uid;
    private long createTime;
    private long updateTime;
    private String createdOn;
    private String updatedOn;

    private String admissionNumber;
    private String sname;
    private String dateOfBirth ;
    private String age;
    private String caste;
    private String orphan;
    private String gender;
    private String education;
    private String email;
    //private String class;
    private String schoolAddress;
    private String adharNumber;
    private String mobileNumber;
    private String presentAddress;
    private String permanentAddress;
    private String motherName;
    private String fatherName;
    private String motherAdharNumber;
    private String motherOccupation;
    private String fatherAdharNumber;
    private String fatherOccupation;
    private String motherDearthDate;
    private String motherPlaceOfDeath;
    private String fatherDearthDate;
    private String fatherPlaceOfDeath;
    private String gaurdianName;
    private String gaurdianAdharNumer;
    private String gaurdianOccupation;
    private String gaurdianMobileNumber;
    private String gaurdianEmailId;
    private String gaurdianPresentAddress;
    private String gaurdianPermanentAddress;
    private String attachments;
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getOrphan() {
        return orphan;
    }

    public void setOrphan(String orphan) {
        this.orphan = orphan;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(String adharNumber) {
        this.adharNumber = adharNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherAdharNumber() {
        return motherAdharNumber;
    }

    public void setMotherAdharNumber(String motherAdharNumber) {
        this.motherAdharNumber = motherAdharNumber;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public String getFatherAdharNumber() {
        return fatherAdharNumber;
    }

    public void setFatherAdharNumber(String fatherAdharNumber) {
        this.fatherAdharNumber = fatherAdharNumber;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherDearthDate() {
        return motherDearthDate;
    }

    public void setMotherDearthDate(String motherDearthDate) {
        this.motherDearthDate = motherDearthDate;
    }

    public String getMotherPlaceOfDeath() {
        return motherPlaceOfDeath;
    }

    public void setMotherPlaceOfDeath(String motherPlaceOfDeath) {
        this.motherPlaceOfDeath = motherPlaceOfDeath;
    }

    public String getFatherDearthDate() {
        return fatherDearthDate;
    }

    public void setFatherDearthDate(String fatherDearthDate) {
        this.fatherDearthDate = fatherDearthDate;
    }

    public String getFatherPlaceOfDeath() {
        return fatherPlaceOfDeath;
    }

    public void setFatherPlaceOfDeath(String fatherPlaceOfDeath) {
        this.fatherPlaceOfDeath = fatherPlaceOfDeath;
    }

    public String getGaurdianName() {
        return gaurdianName;
    }

    public void setGaurdianName(String gaurdianName) {
        this.gaurdianName = gaurdianName;
    }

    public String getGaurdianAdharNumer() {
        return gaurdianAdharNumer;
    }

    public void setGaurdianAdharNumer(String gaurdianAdharNumer) {
        this.gaurdianAdharNumer = gaurdianAdharNumer;
    }

    public String getGaurdianOccupation() {
        return gaurdianOccupation;
    }

    public void setGaurdianOccupation(String gaurdianOccupation) {
        this.gaurdianOccupation = gaurdianOccupation;
    }

    public String getGaurdianMobileNumber() {
        return gaurdianMobileNumber;
    }

    public void setGaurdianMobileNumber(String gaurdianMobileNumber) {
        this.gaurdianMobileNumber = gaurdianMobileNumber;
    }

    public String getGaurdianEmailId() {
        return gaurdianEmailId;
    }

    public void setGaurdianEmailId(String gaurdianEmailId) {
        this.gaurdianEmailId = gaurdianEmailId;
    }

    public String getGaurdianPresentAddress() {
        return gaurdianPresentAddress;
    }

    public void setGaurdianPresentAddress(String gaurdianPresentAddress) {
        this.gaurdianPresentAddress = gaurdianPresentAddress;
    }

    public String getGaurdianPermanentAddress() {
        return gaurdianPermanentAddress;
    }

    public void setGaurdianPermanentAddress(String gaurdianPermanentAddress) {
        this.gaurdianPermanentAddress = gaurdianPermanentAddress;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

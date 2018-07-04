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

    private int admissionNumber;
    private String sname;
    private Date dateOfBirth ;
    private int age;
    private String caste;
    private String orphan;
    private String gender;
    private String education;
    private String email;
    //private String class;
    private String schoolAddress;
    private int adharNumber;
    private int mobileNumber;
    private String presentAddress;
    private String permanentAddress;
    private String motherName;
    private String fatherName;
    private int motherAdharNumber;
    private String motherOccupation;
    private String fatherAdharNumber;
    private String fatherOccupation;
    private Date motherDearthDate;
    private String motherPlaceOfDeath;
    private Date fatherDearthDate;
    private String fatherPlaceOfDeath;
    private String gaurdianName;
    private int gaurdianAdharNumer;
    private String gaurdianOccupation;
    private int gaurdianMobileNumber;
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

    public int getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(int admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public int getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(int adharNumber) {
        this.adharNumber = adharNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
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

    public int getMotherAdharNumber() {
        return motherAdharNumber;
    }

    public void setMotherAdharNumber(int motherAdharNumber) {
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

    public Date getMotherDearthDate() {
        return motherDearthDate;
    }

    public void setMotherDearthDate(Date motherDearthDate) {
        this.motherDearthDate = motherDearthDate;
    }

    public String getMotherPlaceOfDeath() {
        return motherPlaceOfDeath;
    }

    public void setMotherPlaceOfDeath(String motherPlaceOfDeath) {
        this.motherPlaceOfDeath = motherPlaceOfDeath;
    }

    public Date getFatherDearthDate() {
        return fatherDearthDate;
    }

    public void setFatherDearthDate(Date fatherDearthDate) {
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

    public int getGaurdianAdharNumer() {
        return gaurdianAdharNumer;
    }

    public void setGaurdianAdharNumer(int gaurdianAdharNumer) {
        this.gaurdianAdharNumer = gaurdianAdharNumer;
    }

    public String getGaurdianOccupation() {
        return gaurdianOccupation;
    }

    public void setGaurdianOccupation(String gaurdianOccupation) {
        this.gaurdianOccupation = gaurdianOccupation;
    }

    public int getGaurdianMobileNumber() {
        return gaurdianMobileNumber;
    }

    public void setGaurdianMobileNumber(int gaurdianMobileNumber) {
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

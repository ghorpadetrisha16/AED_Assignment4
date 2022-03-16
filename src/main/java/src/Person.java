/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Trisha
 */
public class Person implements Serializable{
    
private static final long serialVersionUID = 1L;

private long personId;
private String Name;
private Date dob;
private String ssn;
private String passportNo;
private String communityName;
private String city;
private long mobileNo;
private String emailId;
private String emergencyContactName;
private long emergencyContactMobile;
private char gender;
private char isPatient;

    public Person(long personId, String Name, Date dob, String ssn, String passportNo, String communityName, String city, long mobileNo, String emailId, String emergencyContactName, long emergencyContactMobile, char gender, char isPatient) {
        this.personId = personId;
        this.Name = Name;
        this.dob = dob;
        this.ssn = ssn;
        this.passportNo = passportNo;
        this.communityName = communityName;
        this.city = city;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactMobile = emergencyContactMobile;
        this.gender = gender;
        this.isPatient = isPatient;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public long getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setEmergencyContactMobile(long emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getIsPatient() {
        return isPatient;
    }

    public void setIsPatient(char isPatient) {
        this.isPatient = isPatient;
    }

}

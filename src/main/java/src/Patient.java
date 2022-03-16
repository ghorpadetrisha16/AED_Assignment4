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
public class Patient implements Serializable{

private static final long serialVersionUID = 1L;
private long patientId;
private long personId;
private Date registrationDate;

    public Patient(long patientId, long personId, Date registrationDate) {
        this.patientId = patientId;
        this.personId = personId;
        this.registrationDate = registrationDate;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}

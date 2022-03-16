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
public class PatientReport implements Serializable{

private static final long serialVersionUID = 1L;

private long patientId;
private Date reportDate;
private String generatedReport;
private Boolean abnormalBP;
private Boolean abnormalSugar;
private Boolean abnormalThyroid;
private Boolean abnormalBMI;
private Boolean abnormalHemoglobin;
private Boolean abnormalWBC;
private Boolean abnormalRBC;
private Boolean abnormalPulseRate;
private Boolean abnormalBodyTemprature;
private Boolean abnormalRespirationRate;

    public PatientReport(long patientId, Date reportDate, String generatedReport, Boolean abnormalBP, Boolean abnormalSugar, Boolean abnormalThyroid, Boolean abnormalBMI, Boolean abnormalHemoglobin, Boolean abnormalWBC, Boolean abnormalRBC, Boolean abnormalPulseRate, Boolean abnormalBodyTemprature, Boolean abnormalRespirationRate) {
        this.patientId = patientId;
        this.reportDate = reportDate;
        this.generatedReport = generatedReport;
        this.abnormalBP = abnormalBP;
        this.abnormalSugar = abnormalSugar;
        this.abnormalThyroid = abnormalThyroid;
        this.abnormalBMI = abnormalBMI;
        this.abnormalHemoglobin = abnormalHemoglobin;
        this.abnormalWBC = abnormalWBC;
        this.abnormalRBC = abnormalRBC;
        this.abnormalPulseRate = abnormalPulseRate;
        this.abnormalBodyTemprature = abnormalBodyTemprature;
        this.abnormalRespirationRate = abnormalRespirationRate;
    }

    

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getGeneratedReport() {
        return generatedReport;
    }

    public void setGeneratedReport(String generatedReport) {
        this.generatedReport = generatedReport;
    }

    public Boolean getAbnormalBP() {
        return abnormalBP;
    }

    public void setAbnormalBP(Boolean abnormalBP) {
        this.abnormalBP = abnormalBP;
    }

    public Boolean getAbnormalSugar() {
        return abnormalSugar;
    }

    public void setAbnormalSugar(Boolean abnormalSugar) {
        this.abnormalSugar = abnormalSugar;
    }

    public Boolean getAbnormalThyroid() {
        return abnormalThyroid;
    }

    public void setAbnormalThyroid(Boolean abnormalThyroid) {
        this.abnormalThyroid = abnormalThyroid;
    }

    public Boolean getAbnormalBMI() {
        return abnormalBMI;
    }

    public void setAbnormalBMI(Boolean abnormalBMI) {
        this.abnormalBMI = abnormalBMI;
    }

    public Boolean getAbnormalHemoglobin() {
        return abnormalHemoglobin;
    }

    public void setAbnormalHemoglobin(Boolean abnormalHemoglobin) {
        this.abnormalHemoglobin = abnormalHemoglobin;
    }

    public Boolean getAbnormalWBC() {
        return abnormalWBC;
    }

    public void setAbnormalWBC(Boolean abnormalWBC) {
        this.abnormalWBC = abnormalWBC;
    }

    public Boolean getAbnormalRBC() {
        return abnormalRBC;
    }

    public void setAbnormalRBC(Boolean abnormalRBC) {
        this.abnormalRBC = abnormalRBC;
    }

    public Boolean getAbnormalPulseRate() {
        return abnormalPulseRate;
    }

    public void setAbnormalPulseRate(Boolean abnormalPulseRate) {
        this.abnormalPulseRate = abnormalPulseRate;
    }

    public Boolean getAbnormalBodyTemprature() {
        return abnormalBodyTemprature;
    }

    public void setAbnormalBodyTemprature(Boolean abnormalBodyTemprature) {
        this.abnormalBodyTemprature = abnormalBodyTemprature;
    }

    public Boolean getAbnormalRespirationRate() {
        return abnormalRespirationRate;
    }

    public void setAbnormalRespirationRate(Boolean abnormalRespirationRate) {
        this.abnormalRespirationRate = abnormalRespirationRate;
    }




    
}

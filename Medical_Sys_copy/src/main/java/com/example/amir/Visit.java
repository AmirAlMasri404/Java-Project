package com.example.amir;

import java.io.PrintWriter;
import java.util.Date;

public abstract class Visit implements Reportable{
    private  final int VisitID;
    private static int INC=1;
    private String Symptoms,Diagnosis;
    private Date VisitDate;
    private Clinic clinic;

    // Protected Parent No Args Constructor
    protected Visit() {
        VisitID = INC++;
    }
    // Protected Parent Parameterized Constructor
    protected Visit(String symptoms, String diagnosis, Clinic clinic) {
        VisitID = INC++;
        Symptoms = symptoms;
        Diagnosis = diagnosis;
        VisitDate = new Date();
        this.clinic = clinic;
    }
    // Getters & Setters
    public int getVisitID() {
        return VisitID;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public Date getVisitDate() {
        return VisitDate;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setSymptoms(String symptoms) {
        Symptoms = symptoms;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public void setVisitDate(Date visitDate) {
        VisitDate = visitDate;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public void printVisitInfo(PrintWriter out) {
        out.println("=========================================================");
        out.println("||                  VISIT INFORMATION                  ||");
        out.println("=========================================================");
        out.printf("| %-20s | %-30s |\n", "Visit ID", getVisitID());
        out.printf("| %-20s | %-30s |\n", "Visit Date", getVisitDate());
        out.printf("| %-20s | %-30s |\n", "Symptoms", getSymptoms());
        out.printf("| %-20s | %-30s |\n", "Diagnosis", getDiagnosis());
        out.println("=========================================================");
        out.println("=========================================================");
        out.println("||                  CLINIC INFORMATION                 ||");
        out.println("=========================================================");
        out.printf("| %-20s | %-30s |\n", "Clinic Name", clinic.getClinicName());
        out.printf("| %-20s | %-30s |\n", "Location", clinic.getLocation());
        out.printf("| %-20s | %-30s |\n", "Telephone", clinic.getTelephone());
        out.println("=========================================================");
    }


    public abstract void GenerateReport(PrintWriter out);
}


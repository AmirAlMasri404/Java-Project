package com.example.amir;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Patient {

    // Patient Attributes
    private final int PatientID;
    private static int INC = 1;
    private String PatientName, NationalID, Gender, PhoneNumber, City, Occupation, BloodGroup;
    private boolean Insured;
    private ArrayList<Visit> VisitList;
    private LocalDate DateOfBirth;

    // No Args Constructor
    public Patient(String text, String ptIDText, LocalDate value, String string, String ciText, String occupationValue, String bloodGroupValue, boolean insure) {
        PatientID = INC++;
    }

    // Parametrize Constructor For File Handling
    public Patient(String patientName, String nationalID, LocalDate DateOfBirth, String gender, String phoneNumber, String city, String occupation, String bloodGroup, boolean insured, ArrayList<Visit> visitList) {
        this(patientName, nationalID, DateOfBirth, gender, phoneNumber, city, occupation, bloodGroup, insured);
        VisitList = visitList;
    }

    // Parametrize Constructor For Adding new Patient
    public Patient(String patientName, String nationalID, LocalDate DateOfBirth, String gender, String phoneNumber, String city, String occupation, String bloodGroup, boolean insured) {
        this.PatientID = INC++;
        this.PatientName = patientName;
        this.NationalID = nationalID;
        this.DateOfBirth = DateOfBirth;
        this.Gender = gender;
        this.PhoneNumber = phoneNumber;
        this.City = city;
        this.Occupation = occupation;
        this.BloodGroup = bloodGroup;
        this.Insured = insured;
        VisitList = new ArrayList<>();
    }

    public void AddVisit(Visit visit) {
        VisitList.add(visit);
    }

    // Getters

    public int getPatientID() {
        return PatientID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public String getNationalID() {
        return NationalID;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getCity() {
        return City;
    }

    public String getOccupation() {
        return Occupation;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public boolean isInsured() {
        return Insured;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public void setNationalID(String nationalID) {
        NationalID = nationalID;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public void setInsured(boolean insured) {
        Insured = insured;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void PatientInfo(PrintWriter out) {
        String S;
        if (Insured) S = "Yes";
        else S = "No";
        out.println("                                    =========================================================================================");
        out.println("                                    ||                                PATIENT INFORMATION                                  ||");
        out.println("                                    =========================================================================================");
        out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        out.printf("| %-10s | %-15s | %-12s | %-30s | %-8s | %-12s | %-10s | %-12s | %-12s | %-10s |\n",
                "PatientID", "Name", "NationalID", "BirthDate", "Gender",
                "Phone", "City", "Occupation", "Blood", "Insured");
        out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        out.printf("| %-10s | %-15s | %-12s | %-30s | %-8s | %-12s | %-10s | %-12s | %-12s | %-10s |\n",
                PatientID, PatientName, NationalID, DateOfBirth, Gender,
                PhoneNumber, City, Occupation, BloodGroup, S);
        out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
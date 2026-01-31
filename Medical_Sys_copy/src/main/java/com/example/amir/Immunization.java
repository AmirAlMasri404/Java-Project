package com.example.amir;

import java.io.PrintWriter;

public class Immunization extends Visit {
    private String VaccineName;
    private double Dose;
    // No Args Constructor
    public Immunization() {
        super();
    }
    // Parametrized Constructor
    public  Immunization(String symptoms, String diagnosis, Clinic clinic, String vaccineName, double dose) {
        super(symptoms, diagnosis, clinic);
        VaccineName = vaccineName;
        Dose = dose;
    }
    // Getters & Setters
    public String getVaccineName() {
        return VaccineName;
    }

    public void setVaccineName(String vaccineName) {
        VaccineName = vaccineName;
    }

    public double getDose() {
        return Dose;
    }

    public void setDose(double dose) {
        Dose = dose;
    }

    @Override
    public void GenerateReport(PrintWriter out) {
        super.printVisitInfo(out);
        out.println("=========================================================");
        out.println("||                  IMMUNIZATION                       ||");
        out.println("=========================================================");
        out.printf("| %-20s | %-30s |\n", "Vaccine Name", VaccineName);
        out.printf("| %-20s | %-30s |\n", "Dose", Dose + " mL");
        out.println("=========================================================");

    }
}

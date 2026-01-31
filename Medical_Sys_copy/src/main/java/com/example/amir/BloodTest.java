package com.example.amir;

import java.io.PrintWriter;

public class BloodTest extends Visit {
    private double RBC;
    private double WBC;
    private double Platelets;
    // No Arg Constructor
    public BloodTest() {
        super();
    }
    // Parametrized Constructor
    public BloodTest(String symptoms, String diagnosis, Clinic clinic, double RBC, double WBC, double platelets) {
        super(symptoms, diagnosis,clinic);
        this.RBC = RBC;
        this.WBC = WBC;
        Platelets = platelets;
    }
    // Getters & Setters
    public double getRBC() {
        return RBC;
    }

    public void setRBC(double RBC) {
        this.RBC = RBC;
    }

    public double getWBC() {
        return WBC;
    }

    public void setWBC(double WBC) {
        this.WBC = WBC;
    }

    public double getPlatelets() {
        return Platelets;
    }

    public void setPlatelets(double platelets) {
        Platelets = platelets;
    }

    @Override
    public void GenerateReport(PrintWriter out) {
        super.printVisitInfo(out);
        out.println("=========================================================");
        out.println("||                  BLOOD TEST                         ||");
        out.println("=========================================================");
        out.printf("| %-20s | %-30s |\n", "Red Blood Cells", RBC + " g/dL");
        out.printf("| %-20s | %-30s |\n", "White Blood Cells", WBC + " µL");
        out.printf("| %-20s | %-30s |\n", "Platelets", Platelets + " µL");
        out.println("=========================================================");

    }
}

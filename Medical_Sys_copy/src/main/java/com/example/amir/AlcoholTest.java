package com.example.amir;

import java.io.PrintWriter;

public class AlcoholTest extends Visit {
    private double AlcoholConcentration;
    private boolean TestResult;
    // No Arg Constructor
    public AlcoholTest() {
        super();
    }
    // Parametrized Constructor
    public AlcoholTest(String symptoms, String diagnosis, Clinic clinic, double alcoholConcentration, boolean testResult) {
        super(symptoms, diagnosis, clinic);
        AlcoholConcentration = alcoholConcentration;
        TestResult = testResult;
    }
    // Getters & Setters
    public double getAlcoholConcentration() {
        return AlcoholConcentration;
    }

    public void setAlcoholConcentration(double alcoholConcentration) {
        AlcoholConcentration = alcoholConcentration;
    }

    public boolean isTestResult() {
        return TestResult;
    }

    public void setTestResult(boolean testResult) {
        TestResult = testResult;
    }

    @Override
    public void GenerateReport(PrintWriter out) {
        String Res;
        if(TestResult) Res="POSITIVE";
        else Res="NEGATIVE";
        super.printVisitInfo(out);
        out.println("=========================================================");
        out.println("||                  ALCOHOL TEST                       ||");
        out.println("=========================================================");
        out.printf("| %-20s | %-30s |\n", "BAC", AlcoholConcentration + " g/dL");
        out.printf("| %-20s | %-30s |\n", "Test Result", Res);
        out.println("=========================================================");

    }
}

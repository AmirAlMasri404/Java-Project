package com.example.amir;

import java.io.PrintWriter;

public class Incident extends Visit {
    private String Severity;
    private String BodyPart;
    // No Arg Constructor
    public Incident() {
        super();
    }
    // Parametrized Constructor
    public Incident(String symptoms, String diagnosis, Clinic clinic, String severity, String bodyPart) {
        super(symptoms, diagnosis, clinic);
        Severity = severity;
        BodyPart = bodyPart;
    }

    // Getters & Setters

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getBodyPart() {
        return BodyPart;
    }

    public void setBodyPart(String bodyPart) {
        BodyPart = bodyPart;
    }

    @Override
    public void GenerateReport(PrintWriter out) {
        super.printVisitInfo(out);
        out.println("=========================================================");
        out.println("||                  INCIDENT INFORMATION               ||");
        out.println("=========================================================");

        out.printf("| %-20s | %-30s |\n", "Severity", Severity);
        out.printf("| %-20s | %-30s |\n", "Body Part", BodyPart);
        out.println("=========================================================");

    }
}

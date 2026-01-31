package com.example.amir;

import java.io.*;

public class FileManager {

    public static void Write(Object object) {
        // 'true' = append mode. The try() block ensures 'out' closes automatically.
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("MedicalClinic.txt", true)))) {

            if (object instanceof Patient p) {
                p.PatientInfo(out);
                out.println();
            }
            else if (object instanceof Visit v) {
                v.GenerateReport(out);
                out.println();
            }
        } catch (IOException e) {
            System.err.println("Critical Error writing to file: " + e.getMessage());
        }
    }
}
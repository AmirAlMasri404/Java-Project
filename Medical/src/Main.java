import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
//Amir AlMasri  1240890
//Tasnim Zayet

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> Patients_List = new ArrayList<>();
        ArrayList<Clinic> Clinics_List = new ArrayList<>();
        int choice;
        System.out.println("================================================================================");
        System.out.println("                    Medical Clinic Management System                            ");
        System.out.println("================================================================================");
        System.out.println("Welcome");
        System.out.println("Please wait a few seconds........");
        System.out.println("Loading Data.......");
        System.out.println("================================================================================");
        // Display Menu
        do {
            System.out.println("Please enter your Choice: ");
            System.out.println("1.New Blood Test");
            System.out.println("2.New Alcohol Test");
            System.out.println("3.New Incident Test");
            System.out.println("4.New Immunization Test");
            System.out.println("5.Print Patient Visit Information");
            System.out.println("6.Exit");
            System.out.println("your Choice: ");
            choice= sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: NewBloodTest(sc,Clinics_List,Patients_List);
                    break;
                case 2: NewAlcoholTest(sc,Clinics_List,Patients_List);
                    break;
                case 3: NewIncident(sc,Clinics_List,Patients_List);
                    break;
                case 4: NewImmunization(sc,Clinics_List,Patients_List);
                    break;
                case 5: PrintPatientVisits(sc,Patients_List);
                    break;
                case 6:
                    System.out.println("Closing Medical Clinic Management System.....Please wait... ");
                    System.out.println("================================================================================");
                    System.out.println("                                   Thank You                                    ");
                    System.out.println("================================================================================");
                    break;
                default:
                    System.out.println("Invalid Choice....Try again");
            }
        }while(choice!=6);
    }
    //print Patient Visit list
    public static void PrintPatientVisits(Scanner sc,ArrayList<Patient> Patients_List){
        Patient patient = SearchPatient(sc,Patients_List);
        if(patient!=null) patient.PatientInfo();
    }
    // New Blood Test
    public static void NewBloodTest(Scanner sc,ArrayList<Clinic> Clinics_List,ArrayList<Patient> Patients_List) {
        Patient patient = PatientSelection(sc,Patients_List);
        Clinic clinic = ClinicSelection(sc,Clinics_List);

        if (clinic != null && patient !=null){
            System.out.println("Please enter Symptoms, Diagnosis,RBC count, WBC count and Platelets count: ");
            String sym = sc.nextLine();         // Signs and Symptoms
            String Dia = sc.nextLine();         // Diagnosis
            double RBC = sc.nextDouble();       // Red Blood Cells Count
            sc.nextLine();
            double WBC = sc.nextDouble();       // White Blood Cells Count
            sc.nextLine();
            double PLT = sc.nextDouble();       // Platelets Count
            sc.nextLine();
            Visit V = new BloodTest(sym,Dia,clinic,RBC,WBC,PLT);
            sc.nextLine();
            patient.AddVisit(V);                // Add Visit to Patient's VisitList
            clinic.AddVisit(V);                 // Add Visit to Clinic's VisitList
            System.out.println("Adding New Blood Test is Successful");
        }
        else {
            System.out.println("Adding New Blood Test is not Successful");
        }
    }
    // New Alcohol Test
    public static void NewAlcoholTest(Scanner sc,ArrayList<Clinic> Clinics_List,ArrayList<Patient> Patients_List) {
        Patient patient = PatientSelection(sc,Patients_List);
        Clinic clinic = ClinicSelection(sc,Clinics_List);

        if (clinic != null && patient !=null){
            System.out.println("Please enter Symptoms, Diagnosis,Alcohol Concentration and Result Status (POSITIVE or NEGATIVE): ");
            String sym = sc.nextLine();         // Signs and Symptoms
            String Dia = sc.nextLine();         // Diagnosis
            double ALCOC = sc.nextDouble();     // Alcohol Concentration
            sc.nextLine();
            String ResStatus = sc.nextLine();   // POSITIVE OR NEGATIVE
            Visit V = new AlcoholTest(sym, Dia, clinic, ALCOC,AlcoholRes(ResStatus));
            patient.AddVisit(V);                // Add Visit to Patient's VisitList
            clinic.AddVisit(V);                 // Add Visit to Clinic's VisitList
            System.out.println("Adding New Alcohol Test is Successful");
        }
        else {
            System.out.println("Adding New Alcohol Test is not Successful");
        }
    }

    // New Incident
    public static void NewIncident(Scanner sc,ArrayList<Clinic> Clinics_List,ArrayList<Patient> Patients_List) {
        Patient patient = PatientSelection(sc,Patients_List);
        Clinic clinic = ClinicSelection(sc,Clinics_List);

        if (clinic != null && patient !=null){
            System.out.println("Please enter Symptoms, Diagnosis,Severity(LOW,MEDIUM,HIGH) and Body Part (Organ OR Region): ");
            String sym = sc.nextLine();         // Signs and Symptoms
            String Dia = sc.nextLine();         // Diagnosis
            String SEV = sc.nextLine();         // Trauma Severity
            String BodyPart = sc.nextLine();    // Body Organ Or Region of injury
            Visit V = new Incident(sym, Dia, clinic, SEV,BodyPart);
            patient.AddVisit(V);                // Add Visit to Patient's VisitList
            clinic.AddVisit(V);                 // Add Visit to Clinic's VisitList
            System.out.println("Adding New Incident  is Successful");
        }
        else {
            System.out.println("Adding New Incident  is not Successful");
        }
    }

    // New Immunization
    public static void NewImmunization(Scanner sc,ArrayList<Clinic> Clinics_List,ArrayList<Patient> Patients_List) {
        Patient patient = PatientSelection(sc,Patients_List);
        Clinic clinic = ClinicSelection(sc,Clinics_List);

        if (clinic != null && patient !=null){
            System.out.println("Please enter Symptoms, Diagnosis,Vaccine Name and Dose: ");
            String sym = sc.nextLine();         // Signs and Symptoms
            String Dia = sc.nextLine();         // Diagnosis
            String VacName = sc.nextLine();     // Vaccine Name
            double Dose = sc.nextDouble();      // Injection Dose im milliliters
            sc.nextLine();
            Visit V = new Immunization(sym, Dia, clinic, VacName,Dose);
            patient.AddVisit(V);                // Add Visit to Patient's VisitList
            clinic.AddVisit(V);                 // Add Visit to Clinic's VisitList
            System.out.println("Adding New Immunization  is Successful");
        }
        else {
            System.out.println("Adding New Immunization  is not Successful");
        }
    }


    // New Profile or Existing Patient Selection

    public static Patient PatientSelection(Scanner sc,ArrayList<Patient> Patients_List){
        sc.nextLine();
        System.out.println("New Profile or Existing Patient?");
        String p = sc.nextLine();
        Patient patient;
        if(p.equalsIgnoreCase("new")){
            patient = AddPatient(sc,Patients_List);
        }
        else if (p.equalsIgnoreCase("exist")) {
            patient = SearchPatient(sc,Patients_List);
        }
        else {
            patient = null;
            System.out.println("Invalid Input");
        }
        return patient;
    }

    // New Profile or Existing Clinic Selection

    public static Clinic ClinicSelection(Scanner sc,ArrayList<Clinic> Clinics_List) {
        sc.nextLine();
        System.out.println("New Profile or Existing Clinic?");
        String c = sc.nextLine();
        Clinic clinic;
        if (c.equalsIgnoreCase("new")) {
            clinic = AddClinic(sc, Clinics_List);
        }
        else if (c.equalsIgnoreCase("exist")) {
            clinic = SearchClinic(sc, Clinics_List);
        }
        else {
            clinic = null;
            System.out.println("Invalid Input");
        }
        return clinic;
    }

    // Add New Clinic

    public static Clinic AddClinic(Scanner sc,ArrayList<Clinic> Clinics_List){
        System.out.println("Please enter Clinic's Information:  ClinicName, Location, Telephone");
        String ClinicName = sc.nextLine();          // Name
        String Location = sc.nextLine();            // Location Description
        String Telephone = sc.nextLine();           // Telephone
        Clinic C = new Clinic(ClinicName,Location,Telephone);
        Clinics_List.add(C);
        return C;
    }

    // Search for Existing Patient

    public static Patient SearchPatient(Scanner sc,ArrayList <Patient> Patients_List){
        System.out.println("Please enter Patient Name: ");
        String PatientName = sc.nextLine();
        for (Patient p : Patients_List){
            if ((p.getPatientName()).equalsIgnoreCase(PatientName)) return p;
        }
        System.out.println("Patient is not Exist");
        return null;
    }

    // Add New Patient

    public static Patient AddPatient(Scanner sc,ArrayList<Patient> Patients_List){
        System.out.println("Please enter Patient's Information:  PatientName, NationalID, DateOfBirth, Gender, PhoneNumber, City, Occupation, BloodGroup, Insured or not Respectively");
        String PatientName = sc.nextLine();                 // Name
        String NationalID = sc.nextLine();                  // Identity or Passport ID
        Date DateOfBirth = CleanDate(sc.nextLine());        // Date of Birth DD/MM/YYYY
        String Gender = sc.nextLine();                      // Male or Female
        String PhoneNumber = sc.nextLine();                 // Phone Number
        String City = sc.nextLine();                        // City of living
        String Occupation = sc.nextLine();                  // Employee / Student / Worker
        String BloodGroup = sc.nextLine();                  // Blood Type A+-/B+-/AB+-/O+-
        String Insurance = sc.nextLine();                   // Insured or Not Yes/No
        Patient P = new Patient(PatientName,NationalID,DateOfBirth,Gender,PhoneNumber,City,Occupation,BloodGroup,Insured(Insurance));
        Patients_List.add(P);
        return P;
    }

    // Search for Existing Clinic

    public static Clinic SearchClinic(Scanner sc,ArrayList<Clinic> Clinics_List){
        System.out.println("Please enter Clinic Name: ");
        String ClinicName = sc.nextLine();
        for (Clinic c : Clinics_List){
            if ((c.getClinicName()).equalsIgnoreCase(ClinicName)) return c;
        }
        System.out.println("Clinic is not Exist");
        return null;
    }

    // Get Birth Date
    public static Date CleanDate(String Date){
        int year,month,day;
        String[] date = Date.split("/");
        day = Integer.parseInt(date[0]);
        month = Integer.parseInt(date[1]);
        year = Integer.parseInt(date[2]);
        return new Date( year-1900, month - 1, day);
    }

    // Insurance Status
    public static boolean Insured(String Insure){
        return Insure.equalsIgnoreCase("yes");
    }

    // Alcohol Result Status
    public static boolean AlcoholRes(String res){
        return res.equalsIgnoreCase("positive");
    }
}

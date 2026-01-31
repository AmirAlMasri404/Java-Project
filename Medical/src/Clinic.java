import java.util.ArrayList;

public class Clinic {
    private String ClinicName,Location,Telephone;
    private ArrayList<Visit> VisitList;

    // No Args Constructor
    public Clinic() {
    }
    // Parametrize Constructor For File Handling
    public Clinic(String clinicName, String location, String telephone, ArrayList<Visit> visitList) {
        this(clinicName, location, telephone);
        VisitList = visitList;
    }
    // Parametrize Constructor For Adding New Clinic
    public Clinic(String clinicName, String location, String telephone) {
        ClinicName = clinicName;
        Location = location;
        Telephone = telephone;
        VisitList = new ArrayList<>();
    }
    // Add visit to the list
    public void AddVisit(Visit visit){
        VisitList.add(visit);
    }
    // Getters & Setters

    public String getClinicName() {
        return ClinicName;
    }

    public String getLocation() {
        return Location;
    }

    public String getTelephone() {
        return Telephone;
    }

    public ArrayList<Visit> getVisitList() {
        return VisitList;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setClinicName(String clinicName) {
        ClinicName = clinicName;
    }

    public void ClinicInfo() {
        System.out.println("=========================================================");
        System.out.println("||                  CLINIC INFORMATION                 ||");
        System.out.println("=========================================================");
        System.out.printf("| %-20s | %-25s |\n", "Clinic Name",ClinicName);
        System.out.printf("| %-20s | %-25s |\n", "Location", Location);
        System.out.printf("| %-20s | %-25s |\n", "Telephone", Telephone);
        System.out.println("=========================================================");

        for (Visit v : VisitList) {
            v.GenerateReport();
        }
        System.out.println("---------------------------------------------------------------------------------------------");    }


}

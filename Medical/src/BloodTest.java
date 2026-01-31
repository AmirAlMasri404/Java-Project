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
    public void GenerateReport() {
        super.printVisitInfo();
        System.out.println("=========================================================");
        System.out.println("||                  BLOOD TEST                         ||");
        System.out.println("=========================================================");
        System.out.printf("| %-20s | %-30s |\n", "Red Blood Cells", RBC + " g/dL");
        System.out.printf("| %-20s | %-30s |\n", "White Blood Cells", WBC + " µL");
        System.out.printf("| %-20s | %-30s |\n", "Platelets", Platelets + " µL");
        System.out.println("=========================================================");

    }
}

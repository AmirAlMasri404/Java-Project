public class Incident extends Visit{
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
    public void GenerateReport() {
        super.printVisitInfo();
        System.out.println("=========================================================");
        System.out.println("||                  INCIDENT INFORMATION               ||");
        System.out.println("=========================================================");

        System.out.printf("| %-20s | %-30s |\n", "Severity", Severity);
        System.out.printf("| %-20s | %-30s |\n", "Body Part", BodyPart);
        System.out.println("=========================================================");

    }
}

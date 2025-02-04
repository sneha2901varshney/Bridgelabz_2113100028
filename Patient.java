public class Patient {
    private static String hospitalName = "PQR Hospital";
    private static int getTotalPatients ;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    
     Patient(String name, int age, String ailment) {
        this.patientID =totalPatients++ ;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }
    
 static int getTotalPatients() {
        return getTotalPatients ;
    }
    
    public void displayDetails()
     {
        if (this instanceof Patient)
         {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
    
    public static void main(String[] args) {
        Patient p1 = new Patient("Ayesha" , 25 , "Cough" );
        Patient p2 = new Patient("Harsh" , 39 , "Fever" );
        
        p1.displayDetails();
        p2.displayDetails();
        
        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}

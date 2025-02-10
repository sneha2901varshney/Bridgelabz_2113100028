import java.util.*;
public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient inPatient = new InPatient("P001", "vikash", 45, 1500, 5);
        inPatient.addRecord("Surgery");
        inPatient.addRecord("Post-op medication");
        
        OutPatient outPatient = new OutPatient("P002", "anju", 30, 5000);
        
        patients.add(inPatient);
        patients.add(outPatient);
        
        for (Patient patient : patients) {
            patient.getPatientDetails();
            
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println();
        }
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public abstract double calculateBill();
    
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Total Bill: " + calculateBill());
    }
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();
    
    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }
    
    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }
    
    @Override
    public void addRecord(String record) {
        records.add(record);
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ": " + records);
    }
}

class OutPatient extends Patient {
    private double consultationFee;
    
    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
}


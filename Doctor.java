
import java.util.*;

public class Doctor {
    private int doctorId;
    private String name;
    private List<Patient> patients;

    public Doctor(int doctorId, String name) {
        this.doctorId = doctorId;
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println("Dr. " + name + " is consulting patient " + patient.getName());
    }

    public String toString() {
        return "Doctor: " + name + " (ID: " + doctorId + ")";
    }

    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(1, "Dr. Ashu");
        Doctor doctor2 = new Doctor(2, "Dr. Kiran");
        Patient patient1 = new Patient(101, "karishma");
        Patient patient2 = new Patient(102, "siya");

        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        System.out.println(doctor1);
        System.out.println(doctor2);
        System.out.println(patient1);
        System.out.println(patient2);
    }
}

class Patient {
    private int patientId;
    private String name;
    private List<Doctor> doctors;

    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Patient: " + name + " (ID: " + patientId + ")";
    }
}




import java.util.*;

abstract class JobRole {
    protected String candidateName;
    protected String experienceLevel;

    public JobRole(String candidateName, String experienceLevel) {
        this.candidateName = candidateName;
        this.experienceLevel = experienceLevel;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return candidateName + " applying for " + getRole() + " (Experience: " + experienceLevel + ")";
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, String experienceLevel) {
        super(candidateName, experienceLevel);
    }

    @Override
    public String getRole() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, String experienceLevel) {
        super(candidateName, experienceLevel);
    }

    @Override
    public String getRole() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, String experienceLevel) {
        super(candidateName, experienceLevel);
    }

    @Override
    public String getRole() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return jobRole.toString();
    }
}

class ResumeScreeningSystem {
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing resume: " + resume);
    }

    public static void screenCandidates(List<? extends JobRole> candidates) {
        for (JobRole candidate : candidates) {
            System.out.println("Screening candidate: " + candidate);
        }
    }
}

public class resumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice Johnson", "Senior"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob Smith", "Mid-Level"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie Brown", "Junior"));

        ResumeScreeningSystem.processResume(seResume);
        ResumeScreeningSystem.processResume(dsResume);
        ResumeScreeningSystem.processResume(pmResume);

        List<JobRole> candidates = Arrays.asList(
                new SoftwareEngineer("David Lee", "Entry"),
                new DataScientist("Emma Watson", "Senior"),
                new ProductManager("Frank White", "Mid-Level")
        );

        System.out.println("\nScreening multiple candidates:");
        ResumeScreeningSystem.screenCandidates(candidates);
    }
}

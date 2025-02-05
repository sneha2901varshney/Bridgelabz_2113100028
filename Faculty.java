
import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Faculty: " + name;
    }

public static void main(String[] args) {
        Faculty faculty1 = new Faculty("Dr. Ashi");
        Faculty faculty2 = new Faculty("Dr. Dev");
        Faculty faculty3 = new Faculty("Dr. Kanika");

        Department department1 = new Department("PQR");
        Department department2 = new Department("Physics");

        department1.addFaculty(faculty1);
        department1.addFaculty(faculty2);
        department2.addFaculty(faculty3);


        University university = new University("XYZ University");
        university.addDepartment(department1);
        university.addDepartment(department2);

        System.out.println("University " + university.getName() + " has departments:");
        for (Department dept : university.getDepartments()) {
            System.out.println(dept);
            for (Faculty faculty : dept.getFacultyMembers()) {
                System.out.println("  " + faculty);
            }
        }

        university.deleteUniversity();

        Faculty independentFaculty = new Faculty("Dr. Manshi");
        System.out.println("Faculty " + independentFaculty.getName() + " is not tied to any department.");
    }

}

class Department {
    private String name;
    private List<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public List<Faculty> getFacultyMembers() {
        return facultyMembers;
    }

    public String toString() {
        return "Department: " + name;
    }
}

class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }

    public void deleteUniversity() {
        System.out.println("Deleting " + name + " and all its departments...");
        departments.clear();
    }

    public String toString() {
        return "University: " + name;
    }
}





import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }


    public void displayEnrolledStudents() {
        System.out.println("Course: " + name + " has the following students enrolled:");
        for (Student student : enrolledStudents) {
            System.out.println(student.getName());
        }
    }
public static void main(String[] args) {
       
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");
        Course course3 = new Course("History");


        Student student1 = new Student("Anamika");
        Student student2 = new Student("Charu");
        Student student3 = new Student("Hemant");

   
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
       
        student2.enrollInCourse(course2);
        student2.enrollInCourse(course3);
       
        student3.enrollInCourse(course1);
        student3.enrollInCourse(course3);

   
        School school = new School("PQR School");
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

   
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();
        student3.displayEnrolledCourses();
       
        course1.displayEnrolledStudents();
        course2.displayEnrolledStudents();
        course3.displayEnrolledStudents();
       
        school.displayStudents();
    }

}

class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);  
    }

    public void displayEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in the following courses:");
        for (Course course : enrolledCourses) {
            System.out.println(course.getName());
        }
    }
}

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Students in " + name + ":");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}


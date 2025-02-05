
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name)
    {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " has enrolled in " + course.getCourseName());
        }
    }

    public void listCourses() {
        System.out.println(name + "'s Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student("Ashi");
        Student s2 = new Student("Priya");

        Professor p1 = new Professor("Dr. Aasheesh");
        Professor p2 = new Professor("Dr. Mehta");

        Course math = new Course("Maths");
        Course ec = new Course("Electronics");

        p1.assignCourse(math);
        p2.assignCourse(ec);

        s1.enrollCourse(math);
        s1.enrollCourse(ec);
        s2.enrollCourse(ec);
       
        math.showCourseDetails();
        ec.showCourseDetails();

        s1.listCourses();
        s2.listCourses();
        p1.listCourses();
        p2.listCourses();
    }
}


class Professor {
    private String name;
    private List<Course> assignedCourses;

    public Professor(String name) {
        this.name = name;
        this.assignedCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
            course.setProfessor(this);
            System.out.println(name + " has been assigned to teach " + course.getCourseName());
        }
    }

    public void listCourses() {
        System.out.println(name + "'s Assigned Courses:");
        for (Course course : assignedCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}


class Course {
    private String courseName;
    private List<Student> students;
    private Professor professor;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void listStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        } else {
            System.out.println("No professor assigned yet.");
        }
        listStudents();
    }
}


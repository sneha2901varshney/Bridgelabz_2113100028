package AssignmentGeneric;
import java.util.*;
abstract class CourseType {
    protected String courseName;
    protected String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public abstract String getEvaluationMethod();

    @Override
    public String toString() {
        return courseName + " (Instructor: " + instructor + ", Evaluation: " + getEvaluationMethod() + ")";
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseType.toString();
    }
}

class University {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void showCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class universityCourseManagementSystem {
    public static void main(String[] args) {
        University university = new University();

        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics", "Dr. Smith"));
        Course<AssignmentCourse> english = new Course<>(new AssignmentCourse("English Literature", "Prof. Johnson"));
        Course<ResearchCourse> physics = new Course<>(new ResearchCourse("Quantum Mechanics", "Dr. Brown"));

        university.addCourse(math);
        university.addCourse(english);
        university.addCourse(physics);

        university.showCourses();
    }
}

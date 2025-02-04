public class Student
{
    private static String universityName = "GLA University" ;
    private static int displayTotalStudents ;
    private String name ;
 private final int rollNumber ;
    private String grade ;

    static int displayTotalStudents()
    {
        return displayTotalStudents ;
    }

    Student(String name , int rollNumber , String grade)
    {
            this.name = name ;
            this.rollNumber = rollNumber ;
            this.grade = grade ;
            displayTotalStudents ++ ;
    }

    public void displayStudentDetails ()
    {
        if (this instanceof Student)
        {
            System.out.println("University Name: " + universityName );
            System.out.println("Student Name: " + name);
            System.out.println("Student Roll Number: " + rollNumber);
            System.out.println("Student Grade: " + grade);
        }
    }
public static void main(String [] args)
{
    Student st1 = new Student ("Anika" , 5 , "A+");
    Student st2 = new Student ("Shreya" , 35, "A+");

    st1.displayStudentDetails();
    st2.displayStudentDetails();

    System.out.println("Total number of Students: " +Student.displayTotalStudents());
}

}
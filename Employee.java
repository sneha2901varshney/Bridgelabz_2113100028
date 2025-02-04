public class Employee
{
    private static String companyName = "HELLO COMPANY" ;
    private String name ;
    private final String id ;
    private String designation ;
    private static String displayTotalEmployees ;

     static String displayTotalEmployees()
     {
        return displayTotalEmployees ;
     }

     Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation ;
    }

    public void displayEmployeeDetails()
    {
        if (this instanceof Employee) 
        {
            System.out.println("Company Name: " + companyName);
            System.out.println("Name: " + this.name);
            System.out.println("ID: " + this.id);
            System.out.println("Designation:" +this.designation);
        }
    }
    
    public static void main(String[] args) 
    {
        Employee emp1 = new Employee ("Saransh" , "67567tgf8" ,"Chef");
        Employee emp2 = new Employee("Abhay" , "8787ygyu8" , "Manager" );

   
       emp1.displayEmployeeDetails();
       emp2.displayEmployeeDetails();
    }
}

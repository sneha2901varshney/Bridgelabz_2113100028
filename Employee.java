import java.util.Scanner;
public class Employee{
   private String name;
   private int id;
   private int salary;

   public Employee(String name, int id, int salary){
     this.name = name;
     this.id = id;
     this.salary = salary;
   }
   public void Details(){
     System.out.println("The Name is" + name);
     System.out.println("The Id is" + id);
     System.out.println("The Salary is" + salary);
   }

  public static void main(String[] args){
     Employee employee1 = new Employee("Harsh", 01, 1000);
     Employee employee2 = new Employee("Ojas", 02, 2000);

 System.out.println("Employee 1");
     employee1.Details();
     System.out.println("Employee 2");
     employee2.Details();
   }
}


import java.util.* ;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

     public static void main(String[] args)
     {
        Company company = new Company("XYZ");

       
        company.addDepartment("IT");
        company.addDepartment("HR");

     
        Department itDept = company.getDepartment("IT");
        if (itDept != null) {
            itDept.addEmployee("Anika");
            itDept.addEmployee("Priya");
        }

        Department hrDept = company.getDepartment("HR");
        if (hrDept != null) {
            hrDept.addEmployee("Udit");
        }

        company.listDepartments();

   
        company.closeCompany();
    }

}

class Department {
    private static String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void listEmployees() {
        System.out.println("Employees in " + name + " Department:");
        for (Employee e : employees) {
            System.out.println("- " + e.getName());
        }
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public Department getDepartment(String departmentName) {
        for (Department dept : departments) {
            if (dept.name.equals(departmentName)) {
                return dept;
            }
        }
        return null;
    }

    public void listDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department dept : departments) {
            System.out.println("- " + dept.name);
            dept.listEmployees();
        }
    }

    public void closeCompany() {
        System.out.println("Closing company: " + name);
        departments.clear();
        System.out.println("All departments and employees have been deleted.");
    }
}


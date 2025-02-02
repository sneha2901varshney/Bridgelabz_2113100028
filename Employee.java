
class Employee:
    def __init__(self, employeeID, department, salary=0):
        self.employeeID = employeeID
        self._department = department
        self.__salary = salary

    def modify_salary(self, amount):
        if amount >= 0:
            self.__salary = amount
        else:
            print("Salary cannot be negative.")

    def get_salary(self):
        return self.__salary

class Manager(Employee):
    def __init__(self, employeeID, department, salary=0):
        super().__init__(employeeID, department, salary)
    
    def get_employeeID(self):
        return self.employeeID
    
    def get_department(self):
        return self._department

employee = Manager(1001, "Sales", 50000)
print(f"Employee ID: {employee.get_employeeID()}")
print(f"Department: {employee.get_department()}")
print(f"Initial Salary: {employee.get_salary()}")

employee.modify_salary(55000)
print(f"Updated Salary: {employee.get_salary()}")


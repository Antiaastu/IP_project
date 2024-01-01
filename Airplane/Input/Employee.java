package Input;

import java.util.Scanner;

public class Employee extends People {
    private int employeeId;
    private String department;
    private double salary;

    public Employee(String name, String email, String address, char sex, String phone, int age,
                    int employeeId, String department, double salary) {
        super(name, email, address, sex, phone, age);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }
    Scanner scanner = new Scanner(System.in);

    public int getEmployeeId() {
        return employeeId;
    }	

public void setEmployeeId() {
	
          
              System.out.print("Enter Employee ID : ");
              this.employeeId=scanner.nextInt();
              scanner.nextLine();
             
    
}

public String getDepartment() {
    return department;
}

public void setDepartment() {
	System.out.print("Enter Employee's department : ");
    this.department = scanner.nextLine();
}

public double getSalary() {
    return salary;
}

public void setSalary() {
	System.out.print("Enter the salary : ");
    this.salary = scanner.nextDouble();
}

public void displayEmployeeInfo() {
    System.out.println("Employee ID: " + employeeId);
    System.out.println("Department: " + department);
    System.out.println("Salary: " + salary);
}
}



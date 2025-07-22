package employe_payroll_machine;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee{
	private String name;
	private int id;
	
	public Employee(String name , int id) {
		this.name=name;
		this.id =id;
	}
	
	public String getName() {
		
		return name;
	}
	public int getId() {
		
		return id;
	}
	
	public abstract double  calculateSalary();
	
	@Override
	public String toString() {
		return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
	}
}

class FullTimeEmployee extends Employee{
	private double monthlySalary;
	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}
	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
	
}

class PartTimeEmployee extends Employee{
	private int hoursWorked;
	private double hourlyRate;
	public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
		super(name,id);
		this.hoursWorked= hoursWorked;
		this.hourlyRate= hourlyRate;
	}
	
	@Override
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}
	
}

class PayrollSystem{
	private ArrayList<Employee> employeeList;
	
	public PayrollSystem() {
		employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee employeToRemove = null;
		for(Employee employee : employeeList) {
			if(employee.getId() == id ) {
				employeToRemove =employee;
				break;
			}
		}
		if(employeToRemove != null) {
			employeeList.remove(employeToRemove);
			System.out.println("Remove Successfully:");
		}
		else {
			System.out.println("Sorry No Employee in Database");
		}
	}
	
	public void displayEmployees() {
		 
			if(employeeList.size()!=0) {
				for(Employee employee : employeeList){
			System.out.println(employee);
				}
			}
			else {
				System.out.println("No employe to dispaly");
			}
			
			
		}
	}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayrollSystem payrollsystem = new PayrollSystem();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n---Payroll Machine ---");
			System.out.println("1. Add full time Employee");
			System.out.println("2. Add Part-Time Employee");
			System.out.println("3. Remove Employee");
			System.out.println("4. Display All Employees");
			System.out.println("5. Close Connection");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			//sc.nextLine(); 
			switch(choice) {
			case 1:
				sc.nextLine();
			System.out.print("Enter name: ");
			String ftName = sc.nextLine();
			
			System.out.print("Enter Id: ");
			int ftId = sc.nextInt();
			//sc.nextLine();
			
			System.out.print("Enter MOntly Salary: ");
			double salary =sc.nextDouble();
			sc.nextLine();
			
			Employee fullEmp = new FullTimeEmployee(ftName,ftId,salary);
			payrollsystem.addEmployee(fullEmp);
			System.out.println("Full-time employee added.");
			break;
			
			case 2:
				sc.nextLine();
			System.out.println("Enter name: ");
			String ptNmae = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Id: ");
			int ptId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Hours Worked: ");
			int hours = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Houry Rate: ");
            double rate = sc.nextDouble();
            sc.nextLine();
			Employee partEmp = new PartTimeEmployee(ptNmae,ptId,hours, rate);
			payrollsystem.addEmployee(partEmp);
			System.out.println("Part-time employee added.");
            break;
            
			case 3:
				System.out.println("Enter id to remove.");
				int removeId = sc.nextInt();
				 sc.nextLine();
				payrollsystem.removeEmployee(removeId);
                break;
                
			case 4:
				payrollsystem.displayEmployees();
				
				break;
			case 5:
				System.out.println("Existing.... Thank You!");
				sc.close();
				System.exit(0);
                break;
             default:
            	 System.out.println("Invalid choice. Try again");
             
			

		}
		}
	}
}

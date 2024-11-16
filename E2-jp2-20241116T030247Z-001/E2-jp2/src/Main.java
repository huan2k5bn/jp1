import Entity.Department;
import Entity.Employee;
import Service.EmployeeService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        service.addDepartment(new Department("D1", "HR"));
        service.addDepartment(new Department("D2", "IT"));

        service.addEmployee(new Employee("E1", "Alice", "D1", LocalDate.of(1990, 11, 15), "female", "Hanoi", "Vietnam", "123456789"));
        service.addEmployee(new Employee("E2", "Bob", "D1", LocalDate.of(1985, 11, 15), "male", "HCM", "Vietnam", "987654321"));
        service.addEmployee(new Employee("E3", "Charlie", "D2", LocalDate.of(1993, 12, 1), "male", "Danang", "Vietnam", "456789123"));

        System.out.println("Employees in HR: " + service.searchByName("HR"));

        System.out.println("Grouped by Department: " + service.groupByDepartment());

        System.out.println("Employee count per Department: " + service.countEmployeesPerDepartment());

        System.out.println("Male employees in HR: " + service.countMaleEmployees("HR"));

        System.out.println("Employees with Birthdays this month: " + service.employeesWithBirthdaysThisMonth());
    }
}

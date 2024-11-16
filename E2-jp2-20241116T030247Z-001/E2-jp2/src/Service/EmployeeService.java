package Service;

import Entity.Department;
import Entity.Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    private Map<String, Department> departments = new HashMap<>();
    private Set<Employee> employees = new HashSet<>();

    public void addDepartment(Department department) {
        departments.put(department.getId(), department);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Set<Employee> searchByName(String deptName) {
        return employees.stream()
                .filter(e -> {
                    Department department = departments.get(e.getDeptId());
                    return department != null && department.getName().equalsIgnoreCase(deptName);
                })
                .collect(Collectors.toSet());
    }

    public Map<String, Set<Employee>> groupByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        e -> departments.get(e.getDeptId()).getName(),
                        Collectors.toSet()
                ));
    }

    public Map<String, Long> countEmployeesPerDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        e -> departments.get(e.getDeptId()).getName(),
                        Collectors.counting()
                ));
    }

    public long countMaleEmployees(String deptName) {
        return employees.stream()
                .filter(e -> "male".equalsIgnoreCase(e.getGender()))
                .filter(e -> {
                    Department department = departments.get(e.getDeptId());
                    return department != null && department.getName().equalsIgnoreCase(deptName);
                })
                .count();
    }

    public Map<String, Set<Employee>> employeesWithBirthdaysThisMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        return employees.stream()
                .filter(e -> e.getDob().getMonthValue() == currentMonth)
                .collect(Collectors.groupingBy(
                        e -> departments.get(e.getDeptId()).getName(),
                        Collectors.toSet()
                ));
    }
}

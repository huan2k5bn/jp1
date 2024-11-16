package Entity;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private String deptId;
    private LocalDate dob;
    private String gender;
    private String city;
    private String province;
    private String phoneNumber;

    public Employee(String id, String name, String deptId, LocalDate dob, String gender, String city, String province, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.dob = dob;
        this.gender = gender;
        this.city = city;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeptId() {
        return deptId;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}

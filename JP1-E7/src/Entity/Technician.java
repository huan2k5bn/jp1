package Entity;

public class Technician extends Staff {
    // Field
    private double overtimePay;

    // Constructor
    public Technician(String name, double salary, double overtimePay) {
        super(name, salary); // Gọi constructor của lớp Staff
        this.overtimePay = overtimePay;
    }

    // Get Paid method
    @Override
    public double getPaid() {
        return getSalary() + overtimePay; // Tính lương + tiền làm thêm giờ
    }

    // toString method
    @Override
    public String toString() {
        return "Technician{" +
                "name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", overtimePay=" + overtimePay +
                ", paid=" + getPaid() +
                '}';
    }
}

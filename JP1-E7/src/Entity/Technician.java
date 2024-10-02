package Entity;

public class Technician extends Staff {

    private double overtimePay;

    public Technician(String name, double salary, double overtimePay) {
        super(name, salary);
        this.overtimePay = overtimePay;
    }

    @Override
    public double getPaid() {
        return getSalary() + overtimePay;
    }

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

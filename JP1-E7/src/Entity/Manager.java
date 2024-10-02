package Entity;

public class Manager extends Staff {
    private double allowance;

    public Manager(String name, double salary, double allowance) {
        super(name, salary);
        this.allowance = allowance;
    }

    @Override
    public double getPaid() {
        return getSalary() + allowance;
    }

    @Override
    public String toString() {
        return "Manager{" + "Name '" + getName() + "/'" + ", Salary=" + getSalary() + ", allowance=" + allowance + ", paid=" + getPaid() + '}';

    }
}

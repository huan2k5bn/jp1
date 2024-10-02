import Entity.Manager;
import Entity.Staff;
import Entity.Technician;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Staff> staffList = new ArrayList<>();

        staffList.add(new Manager("Huan dep trai", 5000, 1500)); // Manager
        staffList.add(new Technician("Huy ngoo", 4000, 500)); // Technician
        staffList.add(new Technician("Loc xau tinh", 4200, 700)); // Technician

        Staff result = staffList.stream()
                .filter(staff -> staff instanceof Manager || staff instanceof Technician)
                .findFirst()
                .orElse(null);

        if (result != null) {
            System.out.println(result.toString());
        }
    }
}

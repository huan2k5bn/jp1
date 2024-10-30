import java.util.HashSet;
import java.util.Set;

public class Main {
    public static boolean isDivisibleBy3(int x) {
        return x % 3 == 0;
    }
    public static void main(String[] args) {
        Set<Integer> so = new HashSet<>();
        so.add(1);
        so.add(2);
        so.add(3);
        so.add(4);
        so.add(5);
        so.add(6);
        so.add(9);
        so.add(12);

        Set<Integer> divisibleBy3Set = new HashSet<>();

        for (int num : so) {
            if (isDivisibleBy3(num)) {
                divisibleBy3Set.add(num);
            }
        }

        System.out.println("Các số chia hết cho 3 là: " + divisibleBy3Set);
    }
}


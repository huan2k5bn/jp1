public class VirtualCafe {
    public static void serveCustomer(VirtualPerson cust, CoffeeCup cup) {
        try {
            cust.drinkCoffee(cup);
        } catch (TooColdException e) {
            System.out.println(e.getMessage());
        } catch (TooHotException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Example {
    public static void main(String[] args) {
        CoffeeCup cup = new CoffeeCup(90);
        VirtualPerson cust = new VirtualPerson();
        VirtualCafe.serveCustomer(cust, cup);
    }
}

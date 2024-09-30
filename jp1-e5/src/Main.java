import Entity.Account;
import Entity.Customer;
import Entity.Invoice;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(
                new Customer(1, "Huấn Đẹp Trai", 'm', 10),
                new Customer(2, "Facebook", 'm', 5),
                new Customer(3, "Instagram", 'f', 15)
        );

        List<Account> accounts = Arrays.asList(
                new Account(1, customers.get(0), 2000.0),
                new Account(2, customers.get(1), 1500.0),
                new Account(3, customers.get(2), 3000.0)
        );

        List<Invoice> invoices = Arrays.asList(
                new Invoice(1, customers.get(0), 5000.0),
                new Invoice(2, customers.get(1), 700.0),
                new Invoice(3, customers.get(2), 400.0)
        );

        customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .forEach(System.out::println);

        Optional<Account> account = accounts.stream()
                .filter(a -> a.getId() == 2)
                .findFirst();
        account.ifPresent(System.out::println);

        invoices.stream()
                .forEach(invoice -> {
                    System.out.println(invoice.getCustomer().getName() +
                            " owes $" + invoice.getAmountAfterDiscount());
                });

        invoices.stream()
                .filter(invoice -> invoice.getAmount() > 0)
                .forEach(System.out::println);

        customers.stream()
                .filter(c -> c.getGender() == 'f')
                .forEach(c -> c.setDiscount(c.getDiscount() + 10));
    }
}

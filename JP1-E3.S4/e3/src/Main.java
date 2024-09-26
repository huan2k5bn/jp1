import Entity.Customer;
import Entity.Invoice;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        Customer c1 = new Customer(1, "Huan dep trai", 10);
        Customer c2 = new Customer(2, "Tran van A", 15);
        Customer c3 = new Customer(3, "Tran van B", 5);

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        invoices.add(new Invoice(101, c1, 888.8));
        invoices.add(new Invoice(102, c2, 999.9));
        invoices.add(new Invoice(103, c3, 500));
        invoices.add(new Invoice(104, c1, 300));
        invoices.add(new Invoice(105, c2, 400));
        invoices.add(new Invoice(106, c3, 700));

        int searchCustomerId = 1;
        System.out.println("Invoices for Customer ID" + searchCustomerId + ":");
        for (Invoice inv : invoices) {
            if (inv.getCustomerId() == searchCustomerId) {
                System.out.println(inv);
            }
        }

        Customer maxAmountCustomer = null;
        double maxTotalAmount = 0;
        for (Customer customer : customers) {
            double totalAmount = 0;
            for (Invoice inv : invoices) {
                if (inv.getCustomerId() == customer.getId()) {
                    totalAmount += inv.getAmount();
                }
            }
            if (totalAmount > maxTotalAmount) {
                maxTotalAmount = totalAmount;
                maxAmountCustomer = customer;
            }
        }
        System.out.println("Customer with the highest total amount: " + maxAmountCustomer);

        Customer minDiscountCustomer = null;
        int minDiscount = Integer.MAX_VALUE;
        for (Customer customer : customers) {
            if (customer.getDiscount() < minDiscount) {
                minDiscount = customer.getDiscount();
                minDiscountCustomer = customer;
            }
        }
        System.out.println("Customer with the smallest discount: " + minDiscountCustomer);

        int searchInvoiceId = 103;
        String searchCustomerName = "Mary";

        System.out.println("Search by Invoice ID " + searchInvoiceId + ":");
        for (Invoice inv : invoices) {
            if (inv.getId() == searchInvoiceId) {
                System.out.println(inv.getCustomer());
            }
        }

        System.out.println("Search by Customer Name '" + searchCustomerName + "':");
        for (Customer customer : customers) {
            if (customer.getName().equals(searchCustomerName)) {
                System.out.println(customer);
            }
        }
    }
}
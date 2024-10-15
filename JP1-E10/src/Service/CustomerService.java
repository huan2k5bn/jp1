package Service;

import Entity.Customer;

import java.util.List;
import java.util.Optional;
import Exception.NotFoundCustomerIdException;
import Global.Global;

public class CustomerService {
    private List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public Customer getCustomerById(String id){
        Optional<Customer> foundCus = customers.stream()
                .filter(customer -> Global.ignoreCase(customer.getId(), id))
                .findFirst();
        return foundCus.orElse(null);
    }
    public List<Customer> getCustomerByName(String customerName){
        List<Customer> foundCus = customers.stream()
                .filter(customer -> Global.ignoreCase(customer.getName(),customerName))
                .toList();
        return foundCus;
    }
}
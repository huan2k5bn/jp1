package Controller;

import java.util.List;

import Controller.Customer;
import Exception.InvalidCustomerNameException;
import Exception.InvalidCustomerIdException;
import Service.CustomerService;
import Exception.NotFoundCustomerIdException;
import Validator.CustomerValidator;
import Exception.NotFoundCustomerNameException;
public class CustomerController {
    private List<Customer> customers;
    private CustomerService cs;

    public CustomerController(CustomerService cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
    }
    public Customer getCustomerById(String id) {
        if (!CustomerValidator.validateCustomerId(id)) {
            System.out.println("Customer id invalid.");
            return null;
        }
        try {
            Customer foundCus = cs.getCustomerById(id);
            return foundCus;
        } catch (NotFoundCustomerIdException | InvalidCustomerIdException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Customer> getCustomerByName(String name) {
        if (!CustomerValidator.validateCustomerName(name)) {
            System.out.println("Customer name invalid.");
            return null;
        }
        try{
            List<Customer> foundCus = cs.getCustomerByName(name);
            return foundCus;
        }
        catch(InvalidCustomerNameException | NotFoundCustomerNameException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
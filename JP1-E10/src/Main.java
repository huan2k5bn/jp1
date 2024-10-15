import Controller.CustomerController;
import Controller.OrderController;
import Controller.OrderDetailController;
import Controller.ProductController;
import Entity.Customer;
import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;
import Service.CustomerService;
import Service.OrderDetailService;
import Service.OrderService;
import Service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Exception.NotEnoughInventoryNumberException;
import Exception.InvalidOrderIdException;
import Exception.InvalidOrderIdException;
import Exception.InvalidProductNameException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        List<Customer> customers = new ArrayList<Customer>();
        List<Product> products = new ArrayList<Product>();
        List<Order> orders = new ArrayList<Order>();
        customers.add(new Customer("001","Nguyen Ngoc Duc"));
        customers.add(new Customer("002","Nguyen Thi Phuong"));
        customers.add(new Customer("003","Le Thi Thao"));

        products.add(new Product("MS123456","Iphone",50));
        products.add(new Product("NE654321","Samsung",30));
        products.add(new Product("SE000001","Oppo",25));

        orders.add(new Order("ORDPM12345678",customers.get(0).getId(), LocalDate.of(2024,8,20)));
        orders.add(new Order("ORDPM12345679",customers.get(1).getId(), LocalDate.of(2024,3,10)));
        orders.add(new Order("ORDPM12345673",customers.get(2).getId(), LocalDate.of(2024,10,1)));

        orderDetails.add(new OrderDetail("ODT1",orders.get(0).getId(),products.get(0).getId(),20));
        orderDetails.add(new OrderDetail("ODT2",orders.get(1).getId(),products.get(1).getId(),10));
        orderDetails.add(new OrderDetail("ODT3",orders.get(2).getId(),products.get(2).getId(),10));

        CustomerService cs = new CustomerService(customers);
        OrderDetailService ods = new OrderDetailService(orderDetails);
        ProductService ps = new ProductService(products);
        OrderService os = new OrderService(orders,ods,ps);
        OrderDetailController odc = new OrderDetailController(ods,ps);
        CustomerController ct = new CustomerController(cs);
        OrderController oc = new OrderController(os,ods,odc,ps);
        ProductController pc = new ProductController(ps);

        try {
            oc.addOrder(customers.get(0).getId(), orderDetails, orders.get(0).getId());
        } catch (NotEnoughInventoryNumberException | InvalidOrderIdException e) {
            System.out.println(e.getMessage());
        }
        Customer foundCus = ct.getCustomerById(customers.get(0).getId());
        System.out.println(foundCus);
        List<Product> foundPrd = pc.getProductByName("iphone");
        System.out.println(foundPrd);
    }
}
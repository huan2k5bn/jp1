package Controller;

import java.util.List;

import Controller.Order;
import Controller.OrderDetail;
import Controller.Product;
import Exception.InvalidOrderIdException;
import Service.OrderDetailService;
import Service.OrderService;
import Exception.NotFoundOrderIdException;
import Exception.NotEnoughInventoryNumberException;
import Service.ProductService;
import Exception.NotFoundProductIdException;
import Validator.CustomerValidator;
import Validator.OrderValidator;
import Exception.InvalidCustomerIdException;
public class OrderController {
    private List<Order> orders;
    private OrderService os;
    private OrderDetailService ods;
    private OrderDetailController odc;
    private Product product;
    private ProductService ps;
    public OrderController(OrderService os, OrderDetailService ods, OrderDetailController odc, ProductService ps) {
        this.os = os;
        this.orders = os.getOrders();
        this.ods = ods;
        this.odc = odc;
        this.ps = ps;
    }
    public Order getOrderById(String id){
        if(OrderValidator.validateOrderId(id)){
            System.out.println("Order ID invalid");
            return null;
        }
        try{
            Order foundOrder = os.getOrderById(String.valueOf(OrderValidator.validateOrderId(id)));
            return foundOrder;
        } catch (NotFoundOrderIdException | InvalidOrderIdException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void addOrder(String customerId, List<OrderDetail> orderDetails, String orderId) {
        if (!OrderValidator.validateOrderId(orderId)) {
            System.out.println("Order ID invalid");
            return;
        }
        if(!CustomerValidator.validateCustomerId(customerId)) {
            System.out.println("Customer ID invalid");
            return;
        }
        if (!odc.checkInventoryNumber(orderDetails)) {
            System.out.println("Inventory number not enough");
            return;
        }
        try{
            List<Order> orders = os.addOrder(customerId, orderDetails, orderId);
            if(orders != null){
                System.out.println("Order has been successfully added with ID: " + orderId + " for customer ID: " + customerId);
            }
            else{
                System.out.println("error adding order");
            }
        }catch (InvalidOrderIdException | InvalidCustomerIdException e) {}

    }



}
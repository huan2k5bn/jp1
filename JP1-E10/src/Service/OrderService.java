package Service;

import Controller.OrderDetailController;
import Entity.Order;

import java.util.List;
import java.util.Optional;

import Entity.OrderDetail;
import Entity.Product;
import Exception.NotFoundOrderIdException;
import Global.Global;
import Validator.CustomerValidator;
import Validator.OrderValidator;

public class OrderService {
    private List<Order> orders;
    private OrderDetailService ods;
    private OrderDetailController odc;
    private Product product;
    private ProductService ps;
    public OrderService(List<Order> orders, OrderDetailService ods, ProductService ps) {
        this.orders = orders;
        this.ods = ods;
        this.ps = ps;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public Order getOrderById(String id) {
        Optional<Order> foundOrder =  orders.stream()
                .filter(order -> Global.ignoreCase(order.getId(),id))
                .findFirst();
        return foundOrder.orElse(null);
    }
    public List<Order> addOrder(String customerId, List<OrderDetail> orderDetails, String orderId) {
        Order newOrder = new Order();
        newOrder.setId(orderId);
        newOrder.setCusId(customerId);
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderId(orderId);
            Product product = ps.getProductById(orderDetail.getProductId());
            if (product != null) {
                product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
            }
        }
        orders.add(newOrder);

        return orders;
    }

}
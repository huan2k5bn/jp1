package Controller;
import Controller.OrderDetail;
import Controller.OrderStatus;
import Controller.Product;
import Exception.InvalidQuantityException;
import Service.OrderDetailService;
import Service.ProductService;
import Exception.NotFoundProductIdException;

import java.util.List;
import Exception.NotEnoughInventoryNumberException;
import Exception.NotFoundOrderIdException;
import Validator.OrderDetailValidator;
import Validator.ProductValidator;
import Exception.InvalidProducIdException;
public class OrderDetailController {
    private List<OrderDetail> orderDetails;
    private ProductService ps;
    private OrderStatus orderStatus;
    private OrderDetailService ods;
    public OrderDetailController(OrderDetailService ods, ProductService ps) {
        this.ods = ods;
        this.orderDetails = ods.getOrderDetails();
        this.ps = ps;
        this.orderStatus = OrderStatus.PENDING;
    }
    public boolean checkInventoryNumber(List<OrderDetail> orderDetails) {
        return orderDetails.stream().allMatch(orderDetail -> { //check xem tất cả các sp có đủ số lượng hay k
            if (!ProductValidator.validateProductId(orderDetail.getProductId())) {
                System.out.println("Invalid Product ID: " + orderDetail.getProductId());
                return false;
            }
            try {
                Product product = ps.getProductById(orderDetail.getProductId());
                if (product.getQuantity() < orderDetail.getQuantity()) {
                    System.out.println("Not enough stock for Product ID: " + orderDetail.getProductId());
                    return false;
                }
                return true;
            } catch (NotFoundProductIdException | InvalidProducIdException e) {
                System.out.println("Error finding Product ID: " + orderDetail.getProductId());
                return false;
            }
        });
    }



    public OrderDetail getOrderDetailById(String id){
        if(OrderDetailValidator.ValidateOrderDetailId(id)){
            System.out.println("Order Detail Id Invalid");
            return null;
        }
        try{
            OrderDetail foundOrderDetail = ods.getOrderDetailById(id);
            return foundOrderDetail;
        } catch (NotFoundOrderIdException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void updateOrderDetailStatus(String orderDetailId, OrderStatus newStatus) {
        if(OrderDetailValidator.ValidateOrderDetailId(orderDetailId)){
            System.out.println("Order Detail Id Invalid");
            return;
        }
        OrderDetail orderDetail = getOrderDetailById(orderDetailId);
        if (orderDetail != null) {
            orderDetail.setStatus(newStatus);
            System.out.println("Order Detail Status " + orderDetailId + " Updated " + newStatus.getDescription());
        } else {
            System.out.println("Order Detail Id Not Found.");
        }
    }
    public void completeOrderDetail(String orderDetailId) {
        updateOrderDetailStatus(orderDetailId, OrderStatus.COMPLETED);
    }

    public void cancelOrderDetail(String orderDetailId) {
        updateOrderDetailStatus(orderDetailId, OrderStatus.CANCEL);
    }

    public void payOrderDetail(String orderDetailId) {
        updateOrderDetailStatus(orderDetailId, OrderStatus.PAID);
    }


}
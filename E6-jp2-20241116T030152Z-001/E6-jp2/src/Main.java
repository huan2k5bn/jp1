
import Entity.OrderDetail;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "orderDetail.in.txt";
        String outputFilePath = "OrderCustomer.out.txt";
        int customerIdToProcess = 1; // Example customer ID to process

        List<OrderDetail> orderDetails = readOrderDetails(inputFilePath);
        List<OrderDetail> customerOrderDetails = filterOrderDetailsByCustomer(orderDetails, customerIdToProcess);
        writeBillingDetails(outputFilePath, customerOrderDetails);
    }

    public static List<OrderDetail> readOrderDetails(String filePath) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                int orderId = Integer.parseInt(parts[1]);
                int productId = Integer.parseInt(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);
                // Assuming DateTime is part of the Order and not needed here
                orderDetails.add(new OrderDetail(id, orderId, productId, quantity, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    public static List<OrderDetail> filterOrderDetailsByCustomer(List<OrderDetail> orderDetails, int customerId) {

        return orderDetails;
    }

    public static void writeBillingDetails(String filePath, List<OrderDetail> orderDetails) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (OrderDetail detail : orderDetails) {
                String line = String.format("Order ID: %d, Product ID: %d, Quantity: %d, Price: %.2f",
                        detail.getOrderId(), detail.getProductId(), detail.getQuantity(), detail.getPrice());
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
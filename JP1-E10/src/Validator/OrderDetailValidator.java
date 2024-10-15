package Validator;

public class OrderDetailValidator {
    public static boolean validateQuantitySold(String soldQty){
        return soldQty.matches("\\d+") && Integer.parseInt(soldQty) > 0;
    }
    public static boolean ValidateOrderDetailId(String id){
        return id.matches("[0-9a-zA-Z]+]");
    }
}
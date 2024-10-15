package Validator;

import java.util.regex.Pattern;

public class ProductValidator {
    public static  boolean validateProductId(String productId){
        return productId.matches("(MS|NE|SE)[0-9]{6}");
    }
    public static boolean validateProductName(String productName){
        return productName.matches("[a-zA-Z\\s]+");
    }
    public static boolean validateProductQuantity(String productQuantity){
        return productQuantity.matches("\\d+") && Integer.parseInt(productQuantity) > 0;
    }
}
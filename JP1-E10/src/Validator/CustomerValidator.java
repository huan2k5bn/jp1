package Validator;

public class CustomerValidator {
    public static boolean validateCustomerName(String cusName) {
        return cusName.matches("[a-zA-Z ]{3,50}");
    }

    public static boolean validateCustomerId(String cusId) {
        return cusId.matches("\\d+") && Integer.parseInt(cusId) > 0;
    }
}
package Validator;

import java.util.regex.Pattern;
import Exception.InvalidOrderIdException;
public class OrderValidator {
    public static boolean validateOrderId(String orderId) {
        return orderId.matches("(ORDPM)[0-9]{8}");
    }
}
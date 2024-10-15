package Exception;

public class InvalidCustomerIdException extends RuntimeException {
    public InvalidCustomerIdException() {
        super();
    }
    public InvalidCustomerIdException(String message) {
        super(message);
    }
    public InvalidCustomerIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
package Exception;

public class InvalidCustomerNameException extends RuntimeException {
    public InvalidCustomerNameException() {
        super();
    }
    public InvalidCustomerNameException(String message) {
        super(message);
    }
    public InvalidCustomerNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
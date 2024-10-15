package Exception;

public class NotFoundCustomerIdException extends Exception {
    public NotFoundCustomerIdException() {
        super();
    }
    public NotFoundCustomerIdException(String message) {
        super(message);
    }
    public NotFoundCustomerIdException(String message, Throwable cause) {
        super(message, cause);
    }
}

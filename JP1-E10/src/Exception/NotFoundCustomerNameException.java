package Exception;

public class NotFoundCustomerNameException extends Exception {
    public NotFoundCustomerNameException() {
        super();
    }
    public NotFoundCustomerNameException(String message) {
        super(message);
    }
    public NotFoundCustomerNameException(String message, Throwable cause) {
        super(message, cause);
    }
}

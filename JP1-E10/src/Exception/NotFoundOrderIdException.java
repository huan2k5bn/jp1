package Exception;

public class NotFoundOrderIdException extends Exception {
    public NotFoundOrderIdException() {
        super();
    }
    public NotFoundOrderIdException(String message) {
        super(message);
    }
    public NotFoundOrderIdException(String message, Throwable cause) {
        super(message, cause);
    }

}

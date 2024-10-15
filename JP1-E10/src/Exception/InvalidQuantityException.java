package Exception;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException() {
        super();
    }
    public InvalidQuantityException(String message) {
        super(message);
    }
    public InvalidQuantityException(String message, Throwable cause) {
        super(message, cause);
    }
}

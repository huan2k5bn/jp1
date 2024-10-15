package Exception;

public class InvalidProductNameException extends Exception {
    public InvalidProductNameException(){
        super();
    }
    public InvalidProductNameException(String message){
        super(message);
    }
    public InvalidProductNameException(String message,Throwable cause){
        super(message,cause);
    }
}

package exceptions;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){
        super("Insufficient fund");
    }

    public InsufficientFundsException(String message){
        super(message);
    }
}

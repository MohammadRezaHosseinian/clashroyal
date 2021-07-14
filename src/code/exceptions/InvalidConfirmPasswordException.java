package code.exceptions;

public class InvalidConfirmPasswordException extends Exception{
    public InvalidConfirmPasswordException(String message){
        super(message);
    }
}

package code.exceptions;
/*
 **
 * this class generate exeption for invalid password
 **
 */

public class InvalidConfirmPasswordException extends Exception{
    public InvalidConfirmPasswordException(String message){
        super(message);
    }
}

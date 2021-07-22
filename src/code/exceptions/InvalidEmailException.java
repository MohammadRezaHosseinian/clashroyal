package code.exceptions;

/*
 **
 * this class generate exeption for invalid email
 **
 */
public class InvalidEmailException extends Exception{
    public InvalidEmailException(String message){
        super(message);
    }
}

package code.exceptions;

/*
 **
 * this class generate exeption for Not found user
 **
 */
public class NotFoundUserException extends Exception{
    public NotFoundUserException(String message){
        super(message);
    }
}
package code.exceptions;

/*
 **
 * this class generate exeption for invalid password pattern
 **
 */
public class InvalidPasswordPatternException extends Exception{
    public InvalidPasswordPatternException(String message){
        super(message);
    }
}

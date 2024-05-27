package EventHandler.exceptions;

public class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String s){
        super(s);
    }
}

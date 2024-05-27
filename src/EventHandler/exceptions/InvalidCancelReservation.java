package EventHandler.exceptions;

public class InvalidCancelReservation extends IllegalArgumentException{
    public InvalidCancelReservation(String s) {
        super(s);
    }
}

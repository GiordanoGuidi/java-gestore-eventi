package EventHandler.exceptions;

public class InvalidBookSeats extends IllegalArgumentException {
    public InvalidBookSeats(String s) {
        super(s);
    }
}

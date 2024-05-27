package EventHandler;

import EventHandler.exceptions.InvalidCancelReservation;
import EventHandler.exceptions.InvalidDateException;
import EventHandler.exceptions.InvalidTotalPlaces;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {
    //Classe Main per fare test
    public static void main(String[] args) {
        Concert concert = new Concert("pippo","2024-06-22",500,"10:30:23",new BigDecimal("123.1234"));
        System.out.println(concert);
    }
    //Attributi
    LocalTime time;
    BigDecimal price;

    //Costruttore
    public Concert(String title, String date, int totalPlaces,String time,BigDecimal price) throws
            InvalidDateException, InvalidTotalPlaces, InvalidCancelReservation {
        super(title, LocalDate.parse(date), totalPlaces);
        this.time = LocalTime.parse(time);
        this.price = price;
    }

    //Getter and Setter
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //Metodi
    //Metodo per  formattare l'ora
    public static String getFormattedTime(LocalTime time,String pattern){
        //Creo un formattatore di date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        //Formatto l'ora ricevuta
        return time.format(formatter);
    }

    //Metodo per formattare il prezzo
    public static String getFormattedPrice(BigDecimal price){
        /*
            restituisco una stringa che rappresenta il valore numerico
            formattato come valuta, utilizzando il formato di valuta del
             locale predefinito.
         */
        return NumberFormat.getCurrencyInstance().format(price);
    }

    //Sovrascrivo il metodo toString
    @Override
    public String toString() {
        return "Concert{" + getDate() + " " +
                getFormattedTime(time,"HH:mm") + " - " +
                getTitle() + " - " +
                getFormattedPrice(price) +
                '}';
    }
}

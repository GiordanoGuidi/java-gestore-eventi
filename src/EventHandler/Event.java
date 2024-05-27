package EventHandler;

import EventHandler.exceptions.InvalidBookSeats;
import EventHandler.exceptions.InvalidCancelReservation;
import EventHandler.exceptions.InvalidDateException;
import EventHandler.exceptions.InvalidTotalPlaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event {
    //Attributi
    private String title;
    private LocalDate date;
    private int totalPlaces;
    private int reservedSeats;

    //Costruttori
    public Event(String title,LocalDate date,int totalPlaces)
    throws InvalidDateException,InvalidTotalPlaces{
        this.title= title;
        this.date= validateDate(date);
        this.totalPlaces= validateTotalPlaces(totalPlaces);
        this.reservedSeats= 0;
    }

    //Getter e Setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date) throws InvalidDateException {
        this.date = validateDate(date);
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }


    public int getReservedSeats(){
        return reservedSeats;
    }

    //Metodi
    //Metodo per validare le data
    private  LocalDate validateDate(LocalDate date) throws InvalidDateException {
        if(date == null || date.isBefore(LocalDate.now())){
            throw new InvalidDateException(" Invalid date: " + date);
        }
        return date;
    }

    //Metodo per validare i posti totali
    private int validateTotalPlaces(int totalPlaces) throws InvalidTotalPlaces{
        if (totalPlaces <=0){
            throw new InvalidTotalPlaces(" Invalid total places value: " + totalPlaces);
        }
        return totalPlaces;
    }

    //Metodo per prenotare posti
    public void bookSeats(int seats) throws InvalidBookSeats{
        //Se la data è passato o non ci sono posti disponibili sollevo un eccezione
        if (date.isBefore(LocalDate.now()) || reservedSeats + seats > totalPlaces){
            int availableSeats = totalPlaces - reservedSeats;
            throw new InvalidBookSeats(" Invalid date: " + date + " or avaiable seats: " + availableSeats);
        }
        reservedSeats = reservedSeats + seats;
        totalPlaces = totalPlaces - reservedSeats;
    }

    //Metodo per disdire la prenotazione
    public void cancelReservation(int seats) throws InvalidCancelReservation{
        if (date.isBefore(LocalDate.now()) || reservedSeats < seats){
            throw new InvalidCancelReservation(" Invalid date: " + date + "or reserved seat < of " + seats);
        }
        reservedSeats = reservedSeats - seats;
        totalPlaces = totalPlaces + seats;
    }

    //Metodo per restituire il resoconto della prenotazione
    public static String eventDetails(Event event){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd", Locale.ENGLISH);
        return String.format("%s - %s", event.getDate().format(formatter),
                event.getTitle());
    }


    @Override
    public String toString() {
        return eventDetails(this);
    }

}

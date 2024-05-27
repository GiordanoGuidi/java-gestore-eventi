package EventHandler;

import EventHandler.exceptions.InvalidDateException;
import EventHandler.exceptions.InvalidTotalPlaces;

import java.time.LocalDate;

public class Event {
    //Attributi
    private String title;
    private LocalDate date;
    private int totalPlaces;
    private int reservedSeats;

    //Costruttori
    public Event(String title,LocalDate date,int totalPlaces,int reservedSeats)
    throws InvalidDateException,InvalidTotalPlaces{
        this.title= title;
        this.date= validateDate(date);
        this.totalPlaces= validateTotalPlaces(totalPlaces);
        this.reservedSeats= 0;
    }

    //Metodi
    //Metodo per validare le data
    private  LocalDate validateDate(LocalDate date) throws InvalidDateException {
        if(date == null || date.isBefore(LocalDate.now())){
            throw new InvalidDateException("Invalid date: " + date);
        }
        return date;
    }

    //Metodo per validare i posti totali
    private int validateTotalPlaces(int totalPlaces) throws InvalidTotalPlaces{
        if (totalPlaces <=0){
            throw new InvalidTotalPlaces("Invalid total places value: " + totalPlaces);
        }
        return totalPlaces;
    }
}

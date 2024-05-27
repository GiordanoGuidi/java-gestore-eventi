package EventHandler;

import EventHandler.exceptions.InvalidBookSeats;
import EventHandler.exceptions.InvalidCancelReservation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;//flag di uscita dal ciclo
        while(!exit){
            System.out.println("Vuoi inserire un evento? y/n");
            String choice = scanner.nextLine();
            switch (choice){
                case "n":
                    //exit
                    exit = true;
                    System.out.println("Bye Bye");
                    break;
                case "y":
                    //insert
                    //Chiamo il metodo per creare un evento
                    Event event = createEvent(scanner);
                    //Chiedo se vuole prenotare dei posti
                    System.out.println("Do you want to reserve seats y/n");
                    choice = (scanner.nextLine());
                    //Chiedo quanti posti vuole prenotare
                    System.out.println("How many seats you want to reserve?");
                    int seats;
                    if (choice.equals("y")){
                        try{
                            seats = Integer.parseInt(scanner.nextLine());
                            System.out.println("posti prenotati" + seats);
                            //Chiamo il metodo per fare la prenotazione
                            event.bookSeats(seats);
                            System.out.println("Totale posti" + event.getTotalPlaces());
                        }catch (NumberFormatException e){
                            System.out.println("Invalid seats value: " + e.getMessage());
                            break;
                        }catch (InvalidBookSeats e){
                            System.out.println("Unable to book reservation" + e.getMessage());
                            break;
                        }
                        //Chiedo se vuole cancellare la prenotazione
                        System.out.println("Do you want to cancel a reservation? y/n");
                        choice = scanner.nextLine();
                        //Chiedo quanti posti aveva la prenotazione
                        System.out.println("How many seats did the reservation include?");
                        int seatsToDelete;
                        try{
                            seatsToDelete = Integer.parseInt(scanner.nextLine());
                            //Chiamo il metodo che esegue la cancellazione della prenotazione
                            event.cancelReservation(seatsToDelete);
                            System.out.println("posti prenotati" + event.getReservedSeats());
                            System.out.println("posti disponibili" + event.getTotalPlaces());
                        }catch (NumberFormatException e){
                            System.out.println("Invalid seats value: " + e.getMessage());
                        }catch (InvalidCancelReservation e){
                            System.out.println("Unable to cancel reservation: " + e.getMessage());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }

    //metodo per creare istanza di Event
    private static Event createEvent(Scanner scanner){
        Event event = null;
    //continuo a ciclare finchè non ho creato l'oggetto
        while (event == null){
            //Nome evento
            System.out.println("Event name");
            String title = scanner.nextLine();
            //Data
            System.out.println("Event date");
            LocalDate date = getDate(scanner);
            //Posti totali
            System.out.println("Total seats");
            int totalPlaces = Integer.parseInt(scanner.nextLine());

            try{
                event = new Event(title,date,totalPlaces);
            }catch (IllegalArgumentException e){
                System.out.println("Unable to create event");
                System.out.println(e.getMessage());
            }
        }
        return event;
    }

    //metodo per continuare a chiedere la data fino a che non è valida
    private static LocalDate getDate(Scanner scanner){
        LocalDate date = null;
        while(date == null){
            String dateString = scanner.nextLine();
            try{
                date = LocalDate.parse(dateString);
            }catch (DateTimeParseException e){
                System.out.println("Invalid date format" + e.getMessage());
            }
        }
        return date;
    }




}


package EventHandler;

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
                    Event event = createEvent(scanner);
                    System.out.println(event);
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


package EventHandler;

import java.util.ArrayList;
import java.util.List;

public class EventPrograms {
    public static void main(String[] args) {
        EventPrograms eventPrograms = new EventPrograms("Lista eventi",eventsList);
        Event event = new Event("pippo","2024-06-22",500);
        eventPrograms.addEvent(event);
        System.out.println(eventPrograms);

    }
    //Attributi
    String title;
    static List<Event> eventsList;
    //Costruttori
    public EventPrograms(String title, List<Event> eventsList) {
        this.title = title;
        this.eventsList = new ArrayList<>();

    }

    //Metodi
    //Metodo per aggiungere un evento alla lista
    public void addEvent(Event event){
        eventsList.add(event);
    }

    @Override
    public String toString() {
        return "EventPrograms{" +
                "title='" + title + "lista=" + eventsList +
                '}';
    }
}

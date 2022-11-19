package agenda;

//import sun.util.resources.LocaleData;

import java.time.*;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    List<Event> events= new ArrayList<Event>();
    public void addEvent(Event e) {
        this.events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iterator to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> Currentev = new ArrayList<Event>();
        for(Event ev:events){
            if(ev.getStart().toLocalDate().equals(day)){
                Currentev.add(ev);
            }
        }
        return Currentev;
    }
    public List<Event> findByTitle(String title) {
        List<Event> evn= new ArrayList<Event>();
        for(Event ev :events){
            if(ev.getTitle().equals(title)){
                evn.add(ev);
            }
        }
        return evn;
    }
    public boolean isFreeFor(Event e) {
        for(Event ev: events){
            if(ev.eventInSameTime(e)){
                return false;
            }
        }
        return true;
    }



}

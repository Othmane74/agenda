package agenda;

import java.time.*;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;

    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        boolean exist=true;
        LocalDate start=this.getStart().toLocalDate();
        LocalDate fin=this.getStart().plus(getDuration()).toLocalDate();

        return aDay.isAfter(start)&& aDay.isBefore(fin) || aDay.isEqual(start) || aDay.isEqual(fin);

    }

    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    public boolean eventInSameTime(Event e){
        LocalDateTime eStart = e.getStart();
        LocalDateTime eEnd = eStart.plus(getDuration());
        LocalDateTime myEnd = this.getStart().plus(getDuration());

        return eStart.isAfter(myStart)&& eEnd.isBefore(myEnd) || eStart.isEqual(myStart) || eEnd.isEqual(myEnd);
    }

    @Override
    public String toString() {
        return "Event{" +
                "myTitle='" + myTitle + '\'' +
                '}';
    }

}

package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */

    private ChronoUnit frequency;
    protected  Set <LocalDate> dateExceptions = new HashSet<LocalDate>();
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {

        dateExceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    @Override
    public boolean isInDay(LocalDate aDay) {
        boolean isInDay = false;
        LocalDate dateDoccurence=super.getStart().toLocalDate();

        do {
            if (dateExceptions.contains(aDay)) {isInDay=false;
                break;}


            LocalDate debut=dateDoccurence;
            LocalDate fin = debut.plusDays(super.getDuration().toDays());
            isInDay = ((aDay.isEqual(debut))||(aDay.isEqual(fin))) || (aDay.isAfter(debut) && aDay.isBefore(fin));
            dateDoccurence= dateDoccurence.plusDays(getFrequency().getDuration().toDays());




        }
        while(ChronoUnit.DAYS.between (dateDoccurence,aDay)>=0);

        return isInDay;
    }
    public Set<LocalDate> getDateExceptions(){
        return dateExceptions;
    }
}

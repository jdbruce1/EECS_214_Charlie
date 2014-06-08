
package scheduleproject;

/**
 * Events class is the base class that abstracts time set aside for a particular
 * purpose. All schedules are composed of events and all GUI visualizations are 
 * based on information stored within the Events class. 
 * Events include
 * <ul>
 * <li> The name of the event as a string
 * <li> The days the event occurs as a string
 * <li> The duration of the event as a Time
 * </ul>
 * 
 * implements the comparable interface and serializable
 * 
 * @author Brownrout
 */
@SuppressWarnings("serial")
public class Events implements Comparable<Events>, java.io.Serializable {
    
    protected String eventName;
    protected String Days;
    protected TimeClass Time;
    
    /**
     * Events constructor for when an event's duration is known
     * 
     * @param name the name of the event as a string
     * @param days the days the event occurs as a string
     * @param hours the hour the event begins as an int. Military time format
     * @param minutes the minutes the event begins as an int. Either 0 or 30
     * @param duration how long the event lasts as an int. Duration is in minutes
     */
    public Events(String name, String days, int hours, int minutes, int duration)
    // String days can be any of the enumerated
    // types below
    {
        this.eventName = name;
        this.Days = days;
        this.Time = new TimeClass(hours, minutes, duration);
    }
    
    /**
     * Events constructor for when an events starting and ending hours and minutes
     * are known
     * 
     * @param name the name of the event as a string
     * @param days the days the event occurs as a string
     * @param startHours the hour the event begins as an int. Military time format
     * @param startMinutes the minutes the event beings as an int. Either 0 or 30
     * @param endHours the hour the event ends as an int. Military time format
     * @param endMinutes the minutes the event ends as an int. Either 0 or 30
     */
    public Events(String name, String days, int startHours, int startMinutes, int endHours, int endMinutes)
    // String days can be any of the enumerated
    // types below
    {
        this.eventName = name;
        this.Days = days;
        this.Time = new TimeClass(startHours, startMinutes,endHours,endMinutes);
    }
    /**
     * Enumerated types representing the different day permutations events could
     * occur
     */
    public enum DaysOfWeek {
        M, MTU, MTUW, MTUWTH, MTUWTHF, MTUWF, MTUTH, MTUTHF, MWF, MW, MWTH, MWTHF, 
        MTUF, MTH, MTHF, MF, W, WTH, WF, WS, F, TU, TUTH, TUWTH, TUWF, TUTHF, TUF, TH,
        TUW, TUWTHF, TUTHS, THF
    }
    /**
     * Overloads the toString method for a neat display of event information as a 
     * string
     * 
     * @return a string displaying the name of the event, days it occurs, and
     *         the start and end of the event
     */
    @Override
    public String toString(){
        
        String output = "\nTitle: " + this.eventName + "\n";
        output += "Days: " + this.Days;
        output += this.Time.toString();
        
        return output;
    }
    /**
     * Getter method for event name
     * 
     * @return the name of the event as a string
     */
    public String getName(){
        return eventName;
    }
    /**
     * Getter method for the days the event occurs
     * 
     * @return the days the event occurs as a string
     */
    public String getDays(){
        return Days;
    }
    /**
     * Getter method for the start time of the event
     * 
     * @return an int of start of the in minutes, in military time format
     */
    public int getTime(){
        return Time.getTime();
    }
    /**
     * Getter method for the start hours of the event
     * 
     * @return the hour the event starts as an int, military time format
     */
    public int getStartHours(){
        return Time.getStartHours();
    }
    /**
     * Getter method for the minutes the event begins
     * 
     * @return the minutes the event starts as an int, either 0 or 30
     */
    public int getStartMinutes(){
        return Time.getStartMinutes();
    }
     /**
     * Getter method for the ending hour of the event
     * 
     * @return the hour the event ends as an int, military time format
     */
    public int getEndHours(){
        return Time.getEndHours();
    }
    /**
     * Getter method for the minutes the event ends
     * 
     * @return the minutes the event ends as an int, either 0 or 30
     */
    public int getEndMinutes(){
        return Time.getEndMinutes();
    }
    /**
     * Getter method for the 
     * 
     * @return the end of the event as an int in minutes, in military time format
     */
    public int getEnd(){
        return Time.getEnd();
    }
    /**
     * Checks if an event occurs on a specified day
     * 
     * @param day the day being checked
     * @return true if the event occurs on the day, false if otherwise
     */
    public boolean occursOnDay(String day){
        return Days.contains(day);
    }
    /**
     * Overloads the compareTo function from the comparable interface. Compares 
     * times of events for purpose of ordering them chronologically by starting
     * time. Does not take into account days, for example an event occurring on
     * Monday at 21:00 would still be after an event occurring on Tuesday at 12:00
     * 
     * @param e the event being compared to this event
     * @return an int either -1 for this event being before that event, 0 for
     *         this and that events occurring at the same time, and 1 for this
     *         event occurring after that event
     *       
     */
    @Override
    public int compareTo(Events e){     
        if (this.getTime()<e.getTime()){
            return -1;
        }
        else{
            if(this.getTime()==e.getTime()){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
    
}

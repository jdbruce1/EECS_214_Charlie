
package scheduleproject;

/**
 * TimeClass abstracts the time aspect of an event including when it begins, 
 * ends, its duration, and the hours and minutes of when it starts
 * 
 * implements Comparable and Serializable
 * 
 * @author Brownrout
 */
@SuppressWarnings("serial")
public class TimeClass implements Comparable<TimeClass>, java.io.Serializable {
	// begin variable declarations
    protected int hours;
    protected int minutes;
    protected int duration;
    protected int start;
    protected int end;
    // end variable declarations
    
    // 6 <= hours <= 22
    // 0 <= minutes <= 59
    // 30 <= duration <= 300
    
    /**
     * Constructor for a TimeClass object when the starting hours, minutes, and
     * duration is known.  
     * 
     * @throws IllegalArgumentException
     * @param hours  the hour the event begins as an int. 
     *               Hours must not be less than 6 or greater than 22.
     * @param minutes the minute the event begins as an int.
     *                Minutes must be 0 or 30
     * @param duration the length of the event in minutes
     */
    public TimeClass(int hours, int minutes, int duration){
        if(hours < 6 || hours+((duration+minutes)/60) > 22){
            throw new IllegalArgumentException("Time must be between 6 AM and 10 PM.");
        }
        if(!(minutes == 0 || minutes == 30)){
            throw new IllegalArgumentException("Please only use half-hour increments.");
        }
        if(duration % 30 != 0){
            throw new IllegalArgumentException("Please only use half-hour time lengths.");
        }
        if(duration <= 0){
            throw new IllegalArgumentException("Start must be later than end.");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.duration = duration;
        this.start = hours*60 + minutes;
        this.end = this.start + duration;
    }
    
    /**
     * Constructor for TimeClass when only the starting and ending hours and
     * minutes are known
     * 
     * @throws IllegalArgumentException
     * @param startHours the hour the event begins as an int. 
     *                   Hours must not be less than 6 or greater than 22.
     * @param startMinutes the minute the event begins as an int.
     *                     Minutes must be 0 or 30
     * @param endHours the hour the event ends as an int. Must be equal to or
     *                 greater than start hours
     * @param endMinutes the minute the event ends as an int. Must be 0 or 30
     */
    public TimeClass(int startHours, int startMinutes, int endHours, int endMinutes){
        if(startHours < 6 || endHours*60+endMinutes > 1320){
            throw new IllegalArgumentException("Time must be between 6 AM and 10 PM.");
        }        
        if(!((startMinutes == 0 || startMinutes == 30) && (endMinutes == 0 || endMinutes == 30))){
            throw new IllegalArgumentException("Please only use half-hour increments.");
        }
        if(startHours * 60 + startMinutes >= endHours * 60 + endMinutes){
            throw new IllegalArgumentException("Start must be before end.");
        }
        
        this.hours = startHours;
        this.minutes = startMinutes;
        this.start = startHours * 60 + startMinutes;
        this.end = endHours * 60 + endMinutes;
        this.duration = this.end - this.start;
    }
    /**
     * Overloaded compareTo method for TimeClass 
     * 
     * @param time2 time to be compared with this time
     * @return 1 if times conflict, 0 otherwise
     */
    @Override
    public int compareTo(TimeClass time2)
    {
        // If start time conflicts
        if(time2.getTime()>=this.getTime()&&time2.getTime()<=(this.getTime()+this.duration)){
            return 1;
        }
        else if((time2.getTime()+time2.duration)>=this.getTime()&&(time2.getTime()+time2.duration)<=(this.getTime()+this.duration)){
            return 1;
        }
        else return 0;
    }
    /**
     * Sets the hours, minutes, and duration of a TimeClass object
     * 
     * @throws IllegalArgumentException
     * @param hours the hour the event begins as an int. Hours must be greater
     *              than 6 but less than 22
     * @param minutes the minute the event begins as an int. Minutes must be 0
     *                or 30.
     * @param duration the length of the event in minutes as an int
     */
    public void setTime(int hours, int minutes, int duration) {
        if(hours < 6 || hours+duration > 22){
            throw new IllegalArgumentException("Time must be between 6 AM and 10 PM");
        }
        if(minutes < 0 || minutes > 60){
            throw new IllegalArgumentException("Minutes must be between 0 and 60");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.duration = duration;
        this.start = hours*60 + minutes;
        this.end = this.start + duration;
    }
    
    /**
     * Getter function for the start of the time
     * 
     * @return the start of the TimeClass object in minutes as an int
     */
    public int getTime() {
        return start;
    }
    
    /**
     * Getter function for the start in hours
     * 
     * @return the start of the TimeClass object in hours as an int 
     */
    public int getStartHours(){
        return start / 60;
    }
    
    /**
     * Getter function for the start in minutes
     * 
     * @return the start of the TimeClass object in minutes as an int
     */
    public int getStartMinutes(){
        return start % 60;
    }
    
     /**
     * Getter function for the end in hours
     * 
     * @return the end of the TimeClass object in hours as an int 
     */
    public int getEndHours(){
        return end / 60;
    }
    
    /**
     * Getter function for the end in minutes
     * 
     * @return the end of the TimeClass object in minutes as an int
     */
    public int getEndMinutes(){
        return end % 60;
    }
    
    /**
     * Getter function for the end of the TimeClass
     * 
     * @return the end of the TimeClass object in minutes as an int
     */
    public int getEnd(){
        return end;
    }
    
    /**
     * Getter function for the length of the event
     * 
     * @return the duration of the event in minutes as an int
     */
    public int getDuration(){
        return duration;
    }
    
    /**
     * Overloads the toString function for TimeClass Objects
     * 
     * @return the start and end of the object in am/pm format as a string
     */
    @Override
    public String toString(){
        return convertTime();
    }
    
    /**
     * Converts the TimeClass object from military time into am/pm format. Is 
     * called by the toString method
     * 
     * @return string containing am/pm formated start and end of a TimeClass object
     */
    public String convertTime() {
        
        String timeOutput = "";
        boolean startPM = false;
        boolean endPM = false;
        
        if((hours*60 + minutes) >= 720){
            startPM = true;
        }
        if((hours*60 + minutes + duration) >= 720){
            endPM = true;
        }
        
        int convertedHours = (start / 60)%12; //since both are ints, you get an int
        if(convertedHours == 0){
            convertedHours = 12;
        }
        int convertedMinutes = start % 60;
        
        timeOutput += "\nStart: " + String.format("%d:%02d", convertedHours, convertedMinutes);
        if(startPM){
            timeOutput += " PM\n";
        }
        else timeOutput += " AM\n";
        
        convertedHours = (end / 60)%12; //since both are ints, you get an int
        if(convertedHours == 0){
            convertedHours = 12;
        }
        convertedMinutes = end % 60;
        
        timeOutput += "End: "  + String.format("%d:%02d", convertedHours, convertedMinutes);
         if(endPM){
            timeOutput += " PM\n";
        }
        else timeOutput += " AM\n";
        
        return timeOutput;
        
    }
    
}

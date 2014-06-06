/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduleproject;

/**
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

    @Override
    public int compareTo(TimeClass time2)
    // return 1 if the times conflict
    // return 0 if the times do not conflict
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

    public int getTime() {
        return start;
    }
    
    public int getStartHours(){
        return start / 60;
    }
    
    public int getStartMinutes(){
        return start % 60;
    }
    
    public int getEndHours(){
        return end / 60;
    }
    
    public int getEndMinutes(){
        return end % 60;
    }
    
    public int getEnd(){
        return end;
    }
    
    public int getDuration(){
        return duration;
    }
    
    @Override
    public String toString(){
        return convertTime();
    }

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

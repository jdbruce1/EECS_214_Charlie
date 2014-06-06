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
public class Events implements Comparable<Events>, java.io.Serializable {
    
    protected String eventName;
    protected String Days;
    protected TimeClass Time;
    
    public Events(String name, String days, int hours, int minutes, int duration)
    // String days can be any of the enumerated
    // types below
    {
        this.eventName = name;
        this.Days = days;
        this.Time = new TimeClass(hours, minutes, duration);
    }
    
    public Events(String name, String days, int startHours, int startMinutes, int endHours, int endMinutes)
    // String days can be any of the enumerated
    // types below
    {
        this.eventName = name;
        this.Days = days;
        this.Time = new TimeClass(startHours, startMinutes,endHours,endMinutes);
    }
    
    public enum DaysOfWeek {
        M, MTU, MTUW, MTUWTH, MTUWTHF, MTUWF, MTUTH, MTUTHF, MWF, MW, MWTH, MWTHF, 
        MTUF, MTH, MTHF, MF, W, WTH, WF, WS, F, TU, TUTH, TUWTH, TUWF, TUTHF, TUF, TH,
        TUW, TUWTHF, TUTHS, THF
    }
    
    @Override
    public String toString(){
        
        String output = "\nTitle: " + this.eventName + "\n";
        output += "Days: " + this.Days;
        output += this.Time.toString();
        
        return output;
    }
    
    public String getName(){
        return eventName;
    }
    
    public String getDays(){
        return Days;
    }
    
    public int getTime(){
        return Time.getTime();
    }
    
    public int getStartHours(){
        return Time.getStartHours();
    }
    
    public int getStartMinutes(){
        return Time.getStartMinutes();
    }
    
    public int getEndHours(){
        return Time.getEndHours();
    }
    
    public int getEndMinutes(){
        return Time.getEndMinutes();
    }
    public int getEnd(){
        return Time.getEnd();
    }
    
    public boolean occursOnDay(String day){
        return Days.contains(day);
    }
    
    @Override
    public int compareTo(Events e){     // Compares times of events for purpose of ordering them.
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

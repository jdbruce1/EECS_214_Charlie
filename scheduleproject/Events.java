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
public class Events implements Comparable<Events>{
    
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
    
    public int getTime(){
        return Time.getTime();
    }
    
    public int getEnd(){
        return Time.getEnd();
    }
    
    public boolean occursOnDay(String day){
        return Days.contains(day);
    }
    
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

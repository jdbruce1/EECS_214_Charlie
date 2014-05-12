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
public class Events {
    
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
        M, MT, MTW, MTWTH, MTWTHF, MTWF, MTTH, MTTHF, MWF, MW, MWTH, MWTHF, MTF,
        MWFS, MTH, MTHF, MF, W, WTH, WF, WS, F, T, TTH, TWTH, TWF, TTHF, TF, TH,
        TW, TWTHF, TTHS, THF
    }
    
    @Override
    public String toString(){
        
        String output = "\nTitle: " + this.eventName + "\n";
        output += "Days: " + this.Days;
        output += this.Time.toString();
        
        return output;
    }
    
    
}

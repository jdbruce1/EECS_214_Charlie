/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Events;

import timeclass.TimeClass;

/**
 *
 * @author Brownrout
 */
public class Events {
    
    protected String Days;
    protected TimeClass time;
    
    public Events(String days, int hours, int minutes, int duration)
    // String days can be any of the enumerated
    // types below
    {
        this.Days = days;
        this.time = new TimeClass(hours, minutes, duration);
    }
    
    public enum DaysOfWeek {
        M, MT, MTW, MTWTH, MTWTHF, MTWF, MTTH, MTTHF, MWF, MW, MWTH, MWTHF, MTF,
        MWFS, MTH, MTHF, MF, W, WTH, WF, WS, F, T, TTH, TWTH, TWF, TTHF, TF, TH,
        TW, TWTHF, TTHS, THF
    }
    
    @Override
    public String toString(){
        return this.time.toString();
    }
    
    
}

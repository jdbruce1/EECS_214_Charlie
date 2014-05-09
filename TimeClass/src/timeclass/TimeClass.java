/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timeclass;

/**
 *
 * @author Brownrout
 */
public class TimeClass implements Comparable<TimeClass>, TimeInterface {

    protected int hours;
    protected int minutes;
    protected int duration;
    protected int start;
    protected int end;
    
    
    /**
     * @param args the command line arguments
     */
    public static void driver(String[] args) {
        // TODO code application logic here
    }
    
    // 6 <= hours <= 22
    // 0 <= minutes <= 59
    // 30 <= duration <= 300
    public TimeClass(int hours, int minutes, int duration){
        this.hours = hours;
        this.minutes = minutes;
        this.duration = duration;
        this.start = hours*60 + minutes;
        this.end = this.start + duration;
    }

    @Override
    public int compareTo(TimeClass o)
    // return 1 if the times overlap
    // return 0 if the times do not conflict
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTime(int hours, int minutes, int duration) {
        this.hours = hours;
        this.minutes = minutes;
        this.duration = duration;
        this.start = hours*60 + minutes;
        this.end = this.start + duration;
    }

    @Override
    public int getTime() {
        return start;
    }
    
    @Override
    public String toString(){
        return convertTime();
    }

    @Override
    public String convertTime() {
        
        String timeOutput = "";
        boolean startPM = false;
        boolean endPM = false;
        
        if((hours*60 + minutes) > 720){
            startPM = true;
        }
        if((hours*60 + minutes + duration) > 720){
            endPM = true;
        }
        
        int convertedHours = (start / 60)%12; //since both are ints, you get an int
        int convertedMinutes = start % 60;
        
        timeOutput += "\nStart: " + String.format("%d:%02d", convertedHours, convertedMinutes);
        if(startPM){
            timeOutput += " PM\n";
        }
        else timeOutput += " AM\n";
        
        convertedHours = (end / 60)%12; //since both are ints, you get an int
        convertedMinutes = end % 60;
        
        timeOutput += "End: "  + String.format("%d:%02d", convertedHours, convertedMinutes);
         if(endPM){
            timeOutput += " PM\n";
        }
        else timeOutput += " AM\n";
        
        return timeOutput;
        
    }
    
}

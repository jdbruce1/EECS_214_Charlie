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
    
    public int getEnd(){
        return end;
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

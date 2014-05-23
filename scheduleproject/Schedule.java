
package scheduleproject;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author jacobbruce
 */
public class Schedule implements java.io.Serializable{
    protected String name;
    protected Events[] events;
    int numEvents;

    public Schedule(){
        name = "";
        events = new Events[30];
        numEvents = 0;
    }
    
    public Schedule(String n) {
        name = n;
        events = new Events[30];
        numEvents = 0;
    }
    
    public Schedule(String n, Events[] e){
        name = n;
        System.arraycopy(e, numEvents, e, numEvents, e.length);
        numEvents = e.length + 1;
    }
    
    public Events[] getEvents(){
        return events;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumber(){
        return numEvents;
    }
    
    public void addEvent(Events e){
        
        Events listElement;
        int location = 0;
        
        while(location < numEvents){
            listElement = (Events) events[location];
            if(((Comparable)listElement).compareTo(e) < 0){
                location ++;
            }
            else{
                break;
            }
        }
        
        for(int index = numEvents; index > location; index --){
            events[index] = events[index - 1];
        }
        
        events[location] = e;
        numEvents++;
        
    }
    
    public void addEventSeq(Events e){
        events[numEvents] = e;
        numEvents ++;
    }
    
    public Events getEventByIndex(int index){
        return events[index];
    }
    
    @Override
    public String toString(){
        
        if(numEvents == 0){
            return "\nThe schedule " + name + " doesn't have any events in it.\n";
        }
        
        String output = "\nThe schedule " + name + " consists of the following events:\n";
        for(int i = 0;i<numEvents;i++){
            output += events[i].toString();
        }
        
        return output;
    }
    
    public void build(){
        
        System.out.println("\nAdding events to your schedule.\n");
        
        OUTER:
        while (true) {
            Scanner inputScan = new Scanner(System.in);
            System.out.println("\nIs your event a class? (y/n, s to stop)\n");
            String quest = inputScan.nextLine();
            switch (quest) {
                case "s":
                    break OUTER;
                case "y":
                    {
                        System.out.println("\nWhat is the title of the class? (not the course number)\n");
                        String title = inputScan.nextLine();
                        System.out.println("\nWhat department is the class in?\n");
                        String department = inputScan.nextLine();
                        System.out.println("\nWhat is the class number?\n");
                        String number = inputScan.nextLine();
                        System.out.println("\nWho teaches the class?\n");
                        String instructor = inputScan.nextLine();
                        System.out.println("\nWhat days of the week does it happen? (MTWTHF)\n");
                        String days = inputScan.nextLine();
                        System.out.println("\nWhat time does it start? (24 hr time) \n");
                        int startTime = inputScan.nextInt();
                        int hour = startTime / 100;
                        int minutes = startTime % 100;
                        System.out.println("\nHow long does it go for? (In minutes)\n");
                        int duration = inputScan.nextInt();
                        
                        this.addEvent(new Course(title, days, hour, minutes, duration,instructor, number,department));

                        System.out.println("\nEvent successfully added. Do you want to add another event to your schedule? (y/n)\n");
                        break;
                    }
                default:
                    {
                        System.out.println("\nWhat is the title of the event?\n");
                        String title = inputScan.nextLine();
                        System.out.println("\nWhat days of the week does it happen? (MTWTHF)\n");
                        String days = inputScan.nextLine();
                        System.out.println("\nWhat time does it start? (24 hr time) \n");
                        int startTime = inputScan.nextInt();
                        int hour = startTime / 100;
                        int minutes = startTime % 100;
                        System.out.println("\nHow long does it go for? (In minutes)\n");
                        int duration = inputScan.nextInt();
                        
                        this.addEvent(new Events(title, days, hour, minutes, duration));

                        System.out.println("\nEvent successfully added. Do you want to add another event to your schedule? (y/n)\n");
                        break;
                    }
            }
        }
        
    }
    
    public Schedule merge(Schedule other){
        Schedule combo = new Schedule(this.name + " and " + other.getName());
        
        for(int i = 0; i<numEvents; i++){   // Add all of the events from the first schedule
            combo.addEvent(events[i]);
        }
        
        for(int j = 0; j<other.getNumber(); j++){
            combo.addEvent(other.getEventByIndex(j));
        }
        
        return combo;
    }
    
    public Schedule invert(){
        
        // Finds free time given a schedule
        
        Schedule freeTime = new Schedule("Free time from the schedule " + this.name);
        Events nextEvent;
        String day = ""; 
        int index;
        int nowMinutes;
        
        for(int i = 1; i<6; i++){
            switch(i){
                case 1:
                    day = "M";
                    break;
                case 2:
                    day = "TU";
                    break;
                case 3:
                    day = "W";
                    break;
                case 4:
                    day = "TH";
                    break;
                case 5:
                    day = "F";
                    break;           
            }
            
            int duration;
            
            nowMinutes = 360;
            index = 0;
            
            while(nowMinutes < 1320){
                
                // If there is none, make a new free time event from the current time ending at 22.

                if(index == numEvents){
                    duration = 1320 - nowMinutes;
                    freeTime.addEventSeq(new Events("Free", day, nowMinutes / 60, nowMinutes % 60, duration));
                    break;
                }
                
                // Look at the next thing in the list
                
                nextEvent = events[index];
                
                // If it's not on the right day, ignore it
                
                if(nextEvent.occursOnDay(day)){
                    
                    // If its start time is before the current time
                        
                    if(nextEvent.getTime() < nowMinutes){
                        // If its end time is before the current time, ignore it
                        
                        // If its end time is after the current time, jump to that end time
                        
                        if(nextEvent.getEnd() > nowMinutes){
                            nowMinutes = nextEvent.getEnd();
                        }
                    }
                    
                    // If its start time is the current time, jump to its end time
                    
                    else if(nextEvent.getTime() == nowMinutes){
                        nowMinutes = nextEvent.getEnd();
                    }
                    
                    // If its start time is after the current time
                    
                    else{
                        // Make a new free time event starting at the current time (on the current day) and ending at the start time of the next thing
                        freeTime.addEventSeq(new Events("Free",day, nowMinutes/60, nowMinutes % 60, nextEvent.getTime() - nowMinutes));
                        // Then jump to the end time of the next thing
                        nowMinutes = nextEvent.getEnd();
                    }   
                }
                index++;  
            }   
        }
        return freeTime;  
    } 
    
    public Schedule bothFree(Schedule other){
        Schedule s = this.merge(other);
        s = s.invert();
        return s;
    }
    
    /*
    
    public void writeSchedule(){
        
        try {
            try (FileOutputStream file = new FileOutputStream("/tmp/schedule.ser"); ObjectOutputStream out = new ObjectOutputStream(file)) {
                out.writeObject(this);
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
        
    }
    
    public void readSchedule(){
        
        
        
    }
*/
    
}


package scheduleproject;
import java.util.Scanner;

/**
 *
 * @author jacobbruce
 */
public class Schedule {
    protected String name;
    protected Events[] events;
    int nextEvent;

    public Schedule(String n) {
        name = n;
        events = new Events[30];
        nextEvent = 0;
    }
    
    public Schedule(String n, Events[] e){
        name = n;
        System.arraycopy(e, nextEvent, e, nextEvent, e.length);
        nextEvent = e.length + 1;
    }
    
    public void addEvent(Events e){
        this.events[nextEvent] = e;
        nextEvent ++;
    }
    
    @Override
    public String toString(){
        
        if(nextEvent == 0){
            return "\nThe schedule " + name + " doesn't have any events in it.\n";
        }
        
        String output = "\nThe schedule " + name + " consists of the following events:\n";
        for(int i = 0;i<nextEvent;i++){
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
    
}

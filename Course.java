package scheduleproject;

/**
 *
 * @author jacobbruce
 */
@SuppressWarnings("serial")
public class Course extends Events{
    
    protected String instructor;
    protected String number;
    protected String department;
    
    public Course(String name, String days, int hours, int minutes, int duration, String instructor, String number, String department)
    // String days can be any of the enumerated
    // types below 
    {
        super(name, days, hours, minutes, duration);
        this.instructor = instructor;
        this.number = number;
        this.department = department;
    }
    
    public Course(String name, String days, int startHours, int startMinutes, int endHours, int endMinutes, String instructor, String number, String department)
    // String days can be any of the enumerated
    // types below 
    {
        super(name, days, startHours, startMinutes, endHours, endMinutes);
        this.instructor = instructor;
        this.number = number;
        this.department = department;
    }
    
    @Override
    public String toString(){
        
        String output = "\nTitle: " + this.eventName + "\n";
        output += "Class number: " + this.department + " " + this.number + "\n";
        output += "Instructor: " + this.instructor + "\n";
        output += "Days: " + this.Days;
        output += this.Time.toString();
        
        return output;   
    }
}

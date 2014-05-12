/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduleproject;

/**
 *
 * @author jacobbruce
 */
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

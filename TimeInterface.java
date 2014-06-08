

package scheduleproject;

/**
 * Interface for TimeClass objects
 * @author Brownrout
 */
public interface TimeInterface {
    
    public void setTime(int hours, int minutes, int duration);
    
    public int getTime();
    
    public String convertTime();
    
}


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
public interface TimeInterface {
    
    public void setTime(int hours, int minutes, int duration);
    
    public int getTime();
    
    public String convertTime();
    
}

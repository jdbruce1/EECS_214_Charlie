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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\
        
        TimeClass test = new TimeClass(5, 30, 60);
        System.out.println(test);
        test.setTime(6, 0, 120);
        System.out.println(test);
        test.setTime(14, 45, 60);
        System.out.println(test);
    }
    
}

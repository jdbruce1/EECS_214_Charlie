/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timeclass;

import Events.Events;

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
        System.out.println("Time 1 is:" + test);
        test.setTime(6, 0, 120);
        System.out.println("Time 1 is:" + test);
        
        TimeClass test2 = new TimeClass(7, 15, 60);
        System.out.println("Time 2 is:" + test2);
        
        TimeClass test3 = new TimeClass(11, 30, 120);
        System.out.println("Time 3 is:" + test3);
        
        TimeClass test4 = new TimeClass(12, 30, 180);
        System.out.println("Time 4 is:" + test4);
        
        TimeClass test5 = new TimeClass(11, 30, 300);
        System.out.println("Time 5 is:" + test5);
        
        System.out.println("Times 1 and 2 conflict?\n" + test.compareTo(test2));
        System.out.println("Times 1 and 3 conflict?\n" + test.compareTo(test3));
        System.out.println("Times 2 and 4 conflict?\n" + test2.compareTo(test4));
        System.out.println("Times 3 and 4 conflict?\n" + test3.compareTo(test4));
        System.out.println("Times 4 and 5 conflict?\n" + test4.compareTo(test5));
        System.out.println("Times 5 and 4 conflict?\n" + test5.compareTo(test4));
        
        Events event1 = new Events("Tester", "MTW", 13, 30, 60);
        System.out.println(event1);
        
    }
    
}

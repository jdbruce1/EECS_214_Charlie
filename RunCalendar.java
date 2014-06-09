
package scheduleproject;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import scheduleproject.Schedule;

/**
 * The main class for the application. Links application logic and GUI creation
 */

public class RunCalendar {

    /**
     * Executes the application builds GUI and links application logic to GUI
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	final Schedule sched = new Schedule();

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeeklyCalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WeeklyCalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WeeklyCalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WeeklyCalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeeklyCalFrame(sched).setVisible(true);
            }
        });
    }
}
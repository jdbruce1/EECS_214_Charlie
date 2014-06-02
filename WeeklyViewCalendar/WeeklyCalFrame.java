/*
 * GUI for the scheduler app
 * basic calendar view of a schedule, with ability to add a new event
 */

package WeeklyViewCalendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import scheduleproject.Schedule;
import scheduleproject.Events;


/**
 *
 * @author Mitchell
 */
@SuppressWarnings("serial")
public class WeeklyCalFrame extends JFrame {
	//TODO this is going to cause problems because you cannot make events after 10PM
	public final static String TIMES[] = {"6:00 AM","6:30 AM","7:00 AM","7:30 AM","8:00 AM",
			"8:30 AM","9:00 AM","9:30 AM","10:00 AM","10:30 AM","11:00 AM","11:30 AM","12:00 PM",
			"12:30 PM","1:00 PM","1:30 PM","2:00 PM","2:30 PM","3:00 PM","3:30 PM","4:00 PM",
			"4:30 PM","5:00 PM","5:30 PM","6:00 PM","6:30 PM","7:00 PM","7:30 PM","8:00 PM",
			"8:30 PM","9:00 PM","9:30 PM","10:00 PM","10:30 PM","11:00 PM"}; 
	
        public final static int TIMES_INT[] = {6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        
        public final static String USER_COLOR = "#8CE8f2";
       
	// Variables declaration - do not modify   
    
    private JPanel dayNamesCont;
    private JPanel timeSideBarCont;
    
    //day panels/columns
    private JPanel monPanel;
    private JPanel tuePanel;
    private JPanel wedPanel;
    private JPanel thuPanel;
    private JPanel friPanel;
 
    private JLabel[] dayLabels;
    private JLabel[] timeLabels;
    
    //event labels
    
    public JLabel[] monEventLabels;
    public JLabel[] tuesEventLabels;
    public JLabel[] wedEventLabels;
    public JLabel[] thurEventLabels;
    public JLabel[] friEventLabels;
    
    // menu items
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenuBar menuCont;
    private JMenuItem newEvent;
    private JMenuItem loadSched;
    private JMenuItem saveSched;
    
    private Schedule mySchedule;
    // end of variables declaration

    /**
     * Creates new form WeeklyCalFrame
     */
    public WeeklyCalFrame(Schedule s) {
    	mySchedule = s;
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {        
        // initialize the menu bar and labels, and other minor details
        createMenu();
        initializeLabels();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(200, 230, 230));
        
        // Initialize event labels
        monEventLabels = new JLabel[18];
        tuesEventLabels = new JLabel[18];
        wedEventLabels = new JLabel[18];
        thurEventLabels = new JLabel[18];
        friEventLabels = new JLabel[18];
        
        
        for(int i = 0; i<monEventLabels.length; i++){
        	monEventLabels[i] = new JLabel();
                tuesEventLabels[i] = new JLabel();
                wedEventLabels[i] = new JLabel();
                thurEventLabels[i] = new JLabel();
                friEventLabels[i] = new JLabel();     
        }

        // Monday panel initialization
        monPanel = new JPanel();
        initializePanel(monPanel);
        GroupLayout mondayLayout = (GroupLayout) monPanel.getLayout();

        //TODO make this cleaner
        mondayLayout.setHorizontalGroup(
            mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(monEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(monEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(monEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        mondayLayout.setVerticalGroup(
            mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mondayLayout.createSequentialGroup()
                .addComponent(monEventLabels[0], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[1], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[2], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[3], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[4], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[5], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[6], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[7], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[8], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[9], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[10], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[11], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[12], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[13], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[14], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[15], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[16], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(monEventLabels[17], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                
            ));

        // Tuesday panel initialization
        tuePanel = new JPanel();
        initializePanel(tuePanel);
        
        GroupLayout tuesdayLayout = (GroupLayout) tuePanel.getLayout();
        
         tuesdayLayout.setHorizontalGroup(
            tuesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tuesEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(tuesEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        tuesdayLayout.setVerticalGroup(
            tuesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tuesdayLayout.createSequentialGroup()
                .addComponent(tuesEventLabels[0], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[1], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[2], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[3], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[4], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[5], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[6], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[7], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[8], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[9], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[10], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[11], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[12], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[13], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[14], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[15], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[16], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(tuesEventLabels[17], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
               
            ));

        // Wednesday panel initialization
        wedPanel = new JPanel();
        initializePanel(wedPanel);
        
        GroupLayout wednesdayLayout = (GroupLayout) wedPanel.getLayout();
        
        wednesdayLayout.setHorizontalGroup(
            wednesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(wedEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wedEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(wedEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        wednesdayLayout.setVerticalGroup(
            wednesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(wednesdayLayout.createSequentialGroup()
                .addComponent(wedEventLabels[0], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[1], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[2], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[3], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[4], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[5], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[6], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[7], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[8], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[9], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[10], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[11], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[12], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[13], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[14], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[15], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[16], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(wedEventLabels[17], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
               
            ));

        // Thursday panel initialization
        thuPanel = new JPanel();
        initializePanel(thuPanel);
        
        GroupLayout thursdayLayout = (GroupLayout) thuPanel.getLayout();
        
        thursdayLayout.setHorizontalGroup(
            thursdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(thurEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(thurEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(thurEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        thursdayLayout.setVerticalGroup(
            thursdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(thursdayLayout.createSequentialGroup()
                .addComponent(thurEventLabels[0], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[1], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[2], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[3], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[4], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[5], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[6], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[7], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[8], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[9], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[10], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[11], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[12], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[13], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[14], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[15], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[16], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(thurEventLabels[17], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                
            ));
        
        // Friday panel initialization
        friPanel = new JPanel();
        initializePanel(friPanel);
       
        GroupLayout fridayLayout = (GroupLayout) friPanel.getLayout();
        
        fridayLayout.setHorizontalGroup(
            fridayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(friEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(friEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(friEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        fridayLayout.setVerticalGroup(
            fridayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fridayLayout.createSequentialGroup()
                .addComponent(friEventLabels[0], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[1], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[2], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[3], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[4], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[5], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[6], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[7], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[8], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[9], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[10], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[11], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[12], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[13], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[14], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[15], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[16], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addComponent(friEventLabels[17], GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        );
        

        dayNamesCont = new JPanel();
        GroupLayout dayNamesContLayout = new GroupLayout(dayNamesCont);
        dayNamesCont.setLayout(dayNamesContLayout);
        dayNamesContLayout.setHorizontalGroup(
            dayNamesContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(dayNamesContLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(dayLabels[0], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(dayLabels[1], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(dayLabels[2], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(dayLabels[3], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(dayLabels[4], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        dayNamesContLayout.setVerticalGroup(
            dayNamesContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(dayLabels[0], GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
            .addComponent(dayLabels[1], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dayLabels[2], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dayLabels[3], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dayLabels[4], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        timeSideBarCont = new JPanel();
        GroupLayout timeSideBarContLayout = new GroupLayout(timeSideBarCont);
        timeSideBarCont.setLayout(timeSideBarContLayout);
        timeSideBarContLayout.setHorizontalGroup(
            timeSideBarContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(timeLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(timeLabels[1], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[2], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[3], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[4], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[5], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[6], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[7], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[8], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[9], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[10], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[11], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[12], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[13], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[14], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[15], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[16], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[17], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        timeSideBarContLayout.setVerticalGroup(
            timeSideBarContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(timeSideBarContLayout.createSequentialGroup()
                .addComponent(timeLabels[0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[5], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[6], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[7], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[8], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[9], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[10], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[11], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[12], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[13], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[14], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[15], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[16], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[17], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                
                .addGap(0, 0, Short.MAX_VALUE))
        );

        
        // this is code that was auto generated by netbeans gui editor
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeSideBarCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(tuePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wedPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(friPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(dayNamesCont, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(dayNamesCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(wedPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thuPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tuePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeSideBarCont, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        // end auto generated code

        pack();
    }// </editor-fold>

    
    // action to be executed when the "new event" menu button is selected
    private void newEventActionPerformed(ActionEvent evt) {
    	NewEventDialog newEventDialog = new NewEventDialog(mySchedule, this);
        newEventDialog.setVisible(true);
        newEventDialog.setSize(newEventDialog.getPreferredSize());
        
        //proof of concept for displaying events
        //TODO pass event labels to dialog box constructor
        
        
    }
    
    // create the menu bar
    private void createMenu(){
        menuCont = new JMenuBar();
        fileMenu = new JMenu();
        newEvent = new JMenuItem();
        editMenu = new JMenu();
		  loadSched = new JMenuItem();
        saveSched = new JMenuItem();
        
        fileMenu.setText("File");

        newEvent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        newEvent.setText("New Event");
        newEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newEventActionPerformed(evt);
            }
        });
        fileMenu.add(newEvent);
        
        loadSched.setText("Load a Schedule");
        loadSched.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(WeeklyCalFrame.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	Serialization s = new Serialization();
                	System.out.println(file.getPath());
                	mySchedule = s.Deserialize(file.getPath());
                }
            }
        });
        fileMenu.add(loadSched);
        
        
        saveSched.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        saveSched.setText("Save Schedule");
        saveSched.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(WeeklyCalFrame.this);
                
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile();
                	try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
                	Serialization s = new Serialization();
                	s.serialize(file.getPath()+".sch", mySchedule);
                }
            }
        });
        fileMenu.add(saveSched);

        menuCont.add(fileMenu);

        editMenu.setText("Edit");
        menuCont.add(editMenu);
        //TODO get add schedule file dialog box to read in serialized schedules
        setJMenuBar(menuCont);
    }
   
    // initialization of the arrays of labels
    private void initializeLabels(){
    	// Initialize day labels
        dayLabels = new JLabel[5];
        for(int i = 0; i<dayLabels.length; i++){
        	dayLabels[i] = new JLabel();
            dayLabels[i].setLabelFor(dayNamesCont);
        }
        dayLabels[0].setText("Monday");
        dayLabels[1].setText("Tuesday");
        dayLabels[2].setText("Wednesday");
        dayLabels[3].setText("Thursday");
        dayLabels[4].setText("Friday");
        
        // Initialize time labels
        timeLabels = new JLabel[18];
        for(int i = 0; i<timeLabels.length; i++){
        	timeLabels[i] = new JLabel();
        	timeLabels[i].setHorizontalAlignment(SwingConstants.TRAILING);
                timeLabels[i].setVerticalTextPosition(JLabel.TOP);
        	timeLabels[i].setLabelFor(timeSideBarCont);
        	timeLabels[i].setText(TIMES[2*i]);
        }
        /*for(int i = 0; i<timeLabels.length; i++){
        	timeLabels[i] = new JLabel();
        	timeLabels[i].setHorizontalAlignment(SwingConstants.TRAILING);
        	timeLabels[i].setLabelFor(timeSideBarCont);
        	timeLabels[i].setText(":"+i);
        }*/
    }
    
    private void initializePanel(JPanel panel){
        panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }
    //fuctions that display events visually 
    protected void setMondayEvents(Events event){
        
        int begI = event.Time.getStartHours()-6;
        int endI = event.Time.getEndHours()-6;
        boolean setTextInLabel = true;
        
        for(int i = begI; i < endI; i++ ){
            if(setTextInLabel){
               monEventLabels[i].setText(event.eventName);
               monEventLabels[i].setVerticalTextPosition(JLabel.TOP);
               setTextInLabel = false;
            }
            monEventLabels[i].setBackground(Color.decode(USER_COLOR));
            monEventLabels[i].setOpaque(true);
        }
    }
    
    protected void setTuesdayEvents(Events event){
         
        int begI = event.Time.getStartHours()-6;
        int endI = event.Time.getEndHours()-6;
        boolean setTextInLabel = true;
        
        for(int i = begI; i < endI; i++ ){
            if(setTextInLabel){
               tuesEventLabels[i].setText(event.eventName);
               tuesEventLabels[i].setVerticalTextPosition(JLabel.TOP);
               setTextInLabel = false;
            }
            tuesEventLabels[i].setBackground(Color.decode(USER_COLOR));
            tuesEventLabels[i].setOpaque(true);
        }
    }
    
    protected void setWednesdayEvents(Events event){
         
        int begI = event.Time.getStartHours()-6;
        int endI = event.Time.getEndHours()-6;
        boolean setTextInLabel = true;
        
        for(int i = begI; i < endI; i++ ){
            if(setTextInLabel){
               wedEventLabels[i].setText(event.eventName);
               wedEventLabels[i].setVerticalTextPosition(JLabel.TOP);
               setTextInLabel = false;
            }
            wedEventLabels[i].setBackground(Color.decode(USER_COLOR));
            wedEventLabels[i].setOpaque(true);
        }
    }
    
    protected void setThursdayEvents(Events event){
         
        int begI = event.Time.getStartHours()-6;
        int endI = event.Time.getEndHours()-6;
        boolean setTextInLabel = true;
        
        for(int i = begI; i < endI; i++ ){
            if(setTextInLabel){
               thurEventLabels[i].setText(event.eventName);
               thurEventLabels[i].setVerticalTextPosition(JLabel.TOP);
               setTextInLabel = false;
            }
            thurEventLabels[i].setBackground(Color.decode(USER_COLOR));
            thurEventLabels[i].setOpaque(true);
        }
    }
    
    protected void setFridayEvents(Events event){
     
        int begI = event.Time.getStartHours()-6;
        int endI = event.Time.getEndHours()-6;
        boolean setTextInLabel = true;
        
        for(int i = begI; i < endI; i++ ){
            if(setTextInLabel){
               friEventLabels[i].setText(event.eventName);
               friEventLabels[i].setVerticalTextPosition(JLabel.TOP);
               setTextInLabel = false;
            }
            friEventLabels[i].setBackground(Color.decode(USER_COLOR));
            friEventLabels[i].setOpaque(true);
        }
    }
}

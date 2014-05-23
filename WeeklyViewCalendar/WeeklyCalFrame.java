/*
 * GUI for the scheduler app
 * basic calendar view of a schedule, with ability to add a new event
 */

package weeklyviewcalendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import scheduleproject.Schedule;

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
    
    //private JSeparator[] separators;
    
    // menu items
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenuBar menuCont;
    private JMenuItem newEvent;
    
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
        
        // Initialize separators
        /*separators = new JSeparator[17];
        for(int i = 0; i<separators.length; i++){
        	separators[i] = new JSeparator();
        }*/

        // Monday panel initialization
        monPanel = new JPanel();
        initializePanel(monPanel);
        /*GroupLayout mondayLayout = (GroupLayout) monPanel.getLayout();

        //TODO make this cleaner
        mondayLayout.setHorizontalGroup(
            mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separators[0], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        mondayLayout.setVerticalGroup(
            mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mondayLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(separators[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[10], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[11], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[12], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[13], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[14], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[15], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[16], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );*/

        // Tuesday panel initialization
        tuePanel = new JPanel();
        initializePanel(tuePanel);

        // Wednesday panel initialization
        wedPanel = new JPanel();
        initializePanel(wedPanel);

        // Thursday panel initialization
        thuPanel = new JPanel();
        initializePanel(thuPanel);
        
        // Friday panel initialization
        friPanel = new JPanel();
        initializePanel(friPanel);
        

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
    	NewEventDialog newEventDialog = new NewEventDialog(mySchedule);
        newEventDialog.setVisible(true);
        newEventDialog.setSize(newEventDialog.getPreferredSize());
    }
    
    
    // create the menu bar
    private void createMenu(){
        menuCont = new JMenuBar();
        fileMenu = new JMenu();
        newEvent = new JMenuItem();
        editMenu = new JMenu();
        
        fileMenu.setText("File");

        newEvent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        newEvent.setText("New Event");
        newEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newEventActionPerformed(evt);
            }
        });
        fileMenu.add(newEvent);

        menuCont.add(fileMenu);

        editMenu.setText("Edit");
        menuCont.add(editMenu);

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
}

package scheduleproject;

import javax.swing.*;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * NewEventDialog class extends the standard Java Swing JDialog component. It is
 * the user interface for manually adding an event to the user's schedule. it opens
 * from selecting add an event from the file menu from the main GUI 
 * 
 * @author Jen
 * @author Mitchell 
 */
@SuppressWarnings("serial")
public class NewEventDialog extends JDialog {
	private static final Logger logger = Logger.getLogger(NewEventDialog.class.getName());
	// variable declarations
	// main container
	private JPanel dialogPanel;
	// name of event label and fields
	private JLabel nameEventLabel;
	private JTextField nameEventField;
	// start and end time labels and fields
	private JLabel startTimeLabel;
	private JComboBox<String> startTimeField;
	private JLabel endTimeLabel;
	private JComboBox<String> endTimeField;
	// day of week label and inputs
	private JLabel dayWeekLabel;
	private JRadioButton monRadioButton;
	private JRadioButton tueRadioButton;
	private JRadioButton wedRadioButton;
	private JRadioButton thuRadioButton;
	private JRadioButton friRadioButton;
	// create event button
	private JButton createEventButton;
	//create reference to WeeklyCalFrame to get both gui elements to talk
	private WeeklyCalFrame calFrame;
	private int colorIndex;
	// end varaible declarations

	/**
         * the constructor for the NewEventDialog box. Initializes and formats
         * all the Java swing components
         *  
         * @param frame the main GUI JFrame, WeeklyCalFrame.
         */
	NewEventDialog(WeeklyCalFrame frame){
		calFrame = frame;
		dialogPanel = new JPanel();
		nameEventField = new JTextField("Enter Name of Event");
		nameEventLabel = new JLabel("Name of Event");

		monRadioButton = new JRadioButton("Monday");
		tueRadioButton = new JRadioButton("Tuesday");
		wedRadioButton = new JRadioButton("Wednesday");
		thuRadioButton = new JRadioButton("Thursday");
		friRadioButton = new JRadioButton("Friday");

		dayWeekLabel = new JLabel("Days of the Week the Event Occurs");
		dayWeekLabel.setToolTipText("");

		startTimeLabel = new JLabel("Start Time");
		endTimeLabel = new JLabel("End Time");

		startTimeField = new JComboBox<String>(Constants.TIMES);
		endTimeField = new JComboBox<String>(Constants.TIMES);

		// create the submit button and add an ActionListener (see below)
		createEventButton = new JButton("Create Event");
		
		createEventButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				createEventButtonActionPerformed(evt);
			}
		});
		
		
		colorIndex = calFrame.colorIndex;

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Create a New Event");
		this.setAlwaysOnTop(true);

		// <editor-fold defaultstate="collapsed" desc="NewEventsDialog Formatting">
		GroupLayout jPanel1Layout = new GroupLayout(dialogPanel);
		dialogPanel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(nameEventLabel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(nameEventField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(monRadioButton)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(tueRadioButton)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(wedRadioButton))
												.addComponent(dayWeekLabel)
												.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addComponent(endTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(thuRadioButton)
																		.addComponent(startTimeLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
																		.addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
																		.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addGroup(jPanel1Layout.createSequentialGroup()
																						.addGap(26, 26, 26)
																						.addComponent(startTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																						.addGroup(jPanel1Layout.createSequentialGroup()
																								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(friRadioButton)))))
																								.addComponent(createEventButton))
																								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(19, 19, 19)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nameEventLabel)
								.addComponent(nameEventField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(7, 7, 7)
								.addComponent(dayWeekLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(monRadioButton)
										.addComponent(tueRadioButton)
										.addComponent(wedRadioButton))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(friRadioButton)
												.addComponent(thuRadioButton))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(startTimeLabel)
														.addComponent(startTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(endTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(endTimeLabel))
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(createEventButton)
																.addGap(22, 22, 22))
				);

		GroupLayout jDialog1Layout = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(
				jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(dialogPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		jDialog1Layout.setVerticalGroup(
				jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(dialogPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
	}// </editor-fold>
        /**
         * Action function for pressing the create event button. Gets information
         * from radial buttons, text field, and drop down menus to construct an
         * event 
         * 
         * @param evt an event detected from clicking the create event button
         */
	private void createEventButtonActionPerformed(ActionEvent evt){    	

                if((getStartHour() + getStartMinutes()) > getEndHour() + getEndMinutes())
                {
                    JOptionPane.showMessageDialog(calFrame, "Please make sure your start time is before your end time");
                }
                else{
		// create and print an event
		Events newEvent = new Events(getName(), getActiveDays(), getStartHour(), getStartMinutes(), getEndHour(), getEndMinutes());
		calFrame.getScheduleFromFrame().addEvent(newEvent);
		logger.log(Level.INFO, "New event created: " + newEvent);


		//make Events visible on the gui
		calFrame.addEvent(newEvent,colorIndex);

		// close dialog box on click of CreateEvent Button
		this.setVisible(false);    
             }
	}

	/**
	 * getCurrentValues gets and neatly prints the information entered by the 
         * user into the NewEventDialog box. Used for testing a debugging purposes
         * 
	 * @return a string version of all of the current input field values
	 */
	public String getCurrentValues(){
		StringBuilder s = new StringBuilder();
		s.append(nameEventLabel.getText()).append(": ").append(getName()).append("\n");
		s.append(startTimeLabel.getText()).append(": ").append(startTimeField.getSelectedItem()).append("\n");
		s.append(endTimeLabel.getText()).append(": ").append(endTimeField.getSelectedItem()).append("\n");

		s.append(monRadioButton.getText()).append(": ").append(monRadioButton.isSelected()).append("\n");
		s.append(tueRadioButton.getText()).append(": ").append(tueRadioButton.isSelected()).append("\n");
		s.append(wedRadioButton.getText()).append(": ").append(wedRadioButton.isSelected()).append("\n");
		s.append(thuRadioButton.getText()).append(": ").append(thuRadioButton.isSelected()).append("\n");
		s.append(friRadioButton.getText()).append(": ").append(friRadioButton.isSelected()).append("\n");

		return s.toString();
	}
        
        /**
         * Getter function for getting the name of the event from user input 
         * text field
         * 
         * @return the name of the event as string
         */
	public String getName(){
		return nameEventField.getText();
	}
        
        /**
         * Translates user selected radial buttons into a string representing the
         * days the event occurs on. Used for debugging.
         * 
         * @return the abbreviated days of the week the event occurs as a string
         */
	public String getActiveDays(){
		StringBuilder s = new StringBuilder("");

		// check for the days that have been marked
		if(monRadioButton.isSelected()){
			s.append("M");
		}
		if(tueRadioButton.isSelected()){
			s.append("TU");
		}
		if(wedRadioButton.isSelected()){
			s.append("W");
		}
		if(thuRadioButton.isSelected()){
			s.append("TH");
		}
		if(friRadioButton.isSelected()){
			s.append("F");
		}

		return s.toString();
	}
        
        /**
         * Gets the starting hour of the event based on the selection from the
         * user. Starting hour is computed based off the index of the time selected
         * by the user in the start time drop down menu
         * 
         * @return the starting hour of the event as an int
         */
	public int getStartHour(){
		int index = startTimeField.getSelectedIndex();
		return (index/2) + 6;
	}
        
        /**
         * Gets the starting minute of the event based off the index of the time
         * selected by the user in the start time drop down menu
         * 
         * @return the starting minute of the event as an int, either 0 or 30
         */
	public int getStartMinutes(){
		int index = startTimeField.getSelectedIndex();
		return (index%2)*30;
	}

        /**
         * Gets the ending hour of the event based on the selection from the
         * user. Ending hour is computed based off the index of the time selected
         * by the user in the end time drop down menu
         * 
         * @return the ending hour of the event as an int
         */
	public int getEndHour(){
		int index = endTimeField.getSelectedIndex();
		return (index/2) + 6;
	}

        /**
         * Gets the ending minute of the event based off the index of the time
         * selected by the user in the end time drop down menu
         * 
         * @return the ending minute of the event as an int, either 0 or 30
         */
	public int getEndMinutes(){
		int index = endTimeField.getSelectedIndex();
		return (index%2)*30;
	}
}
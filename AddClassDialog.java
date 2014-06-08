package scheduleproject;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AddClassDialog extends the standard Java swing JDialog box feature to allow
 * users to select pre-made Northwestern courses to add to their schedules. The
 * AddClassDialog becomes visible upon a user selecting the "Add a class" option
 * under the File menu.
 * 
 * @author Jen
 */

@SuppressWarnings("serial")
public class AddClassDialog extends JDialog{
	private static final Logger logger = Logger.getLogger(AddClassDialog.class.getName());
	// variable declarations
	private JPanel dialogPanel;
	private JComboBox<String> addClassList;
	private int colorIndex;
	private ArrayList<Events> classList;
	private JButton addClassButton;
	private WeeklyCalFrame calendarFrame;
	// end variable declarations

	/** 
         * Constructor for the AddClassDialog box. Initializes the JDialog box
         * with a JLabel instructing the user to select a class. A JComboBox 
         * containing the names of the pre-made courses. A JButton to confirm 
         * the selection.
         * 
         * @param frame The main GUI JFrame. Must be passed so the dialog box 
         *              can access WeeklyCalFrame's methods
         * @param l     Takes in an ArrayList of Courses as events
         */
	AddClassDialog(WeeklyCalFrame frame, ArrayList<Events> l) {
		calendarFrame = frame;
		classList = l;
		dialogPanel = new JPanel();
		colorIndex = calendarFrame.colorIndex;
		addClassButton = new JButton("Add class");	

		// get labels for the combobox
		String names[] = new String[classList.size()];
		for(int i = 0; i<classList.size(); i++){
			names[i] = classList.get(i).eventName;
		}
		addClassList = new JComboBox<String>(names);
		
		// window setup
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Add a class");
		this.setAlwaysOnTop(true);

		// create the submit button and add an ActionListener (see below)
		addClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addEventActionListener();
			}
		});

		dialogPanel.add(new JLabel("Select a class: "));
		dialogPanel.add(addClassList);
		dialogPanel.add(addClassButton);

		this.add(dialogPanel);
	}
	/**
         * Event listener for the select a class JButton. On user click, will
         * add the selected class to the user's schedule and pass the course
         * as an event to the WeeklyCalFrame for display 
         */
	private void addEventActionListener(){
		// prints current values of the buttons
		logger.log(Level.INFO, "Selected Values: " + addClassList.getSelectedItem());

		// get course
		Events newEvent = classList.get(addClassList.getSelectedIndex());
		calendarFrame.getScheduleFromFrame().addEvent(newEvent);
		logger.log(Level.INFO, "Added event to schedule");
		
		//make Events visible on the gui
		calendarFrame.addEvent(newEvent,colorIndex);

		// close dialog box on click of CreateEvent Button
		AddClassDialog.this.setVisible(false);
	}
}
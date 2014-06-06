package scheduleproject;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Jen
 *
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

	// constructor
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
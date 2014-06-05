package scheduleproject;

import javax.swing.*;

import scheduleproject.Schedule;

import java.awt.event.*;
import java.util.ArrayList;


public class AddClassDialog extends JDialog{
	// main container
	private JPanel dialogPanel;

	private JLabel addClassLabel;
	private JComboBox<String> addClassList;
   private int colorIndex;


	private Schedule mySchedule;
	private ArrayList<Events> classList;
	// create event button
	private JButton addClassButton;
	// create reference to WeeklyCalFrame to get both gui elements to talk
	private WeeklyCalFrame weeklyCalJFrame;

	// constructor
	AddClassDialog(Schedule s, WeeklyCalFrame frame, ArrayList<Events> l) {
		mySchedule = s;
		weeklyCalJFrame = frame;
		classList = l;
		dialogPanel = new JPanel();
        colorIndex = weeklyCalJFrame.colorIndex;

		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Add a class");
		this.setAlwaysOnTop(true);

		String names[] = new String[classList.size()];
		for(int i = 0; i<classList.size(); i++){
			names[i] = classList.get(i).eventName;
		}
		
		addClassLabel = new JLabel("Select a class: ");
		addClassList = new JComboBox<String>(names);
		addClassButton = new JButton("Add class");	
		

		// create the submit button and add an ActionListener (see below)
		addClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// prints current values of the buttons
		    	System.out.println("Selected Values:");
		    	System.out.println(addClassList.getSelectedItem());
		    	
		    	// get course
		    	Events newEvent = classList.get(addClassList.getSelectedIndex());
		    	mySchedule.addEvent(newEvent);
		    	System.out.println(mySchedule);
		    	
		        //make Events visible on the gui
		        //Once Mon is debugged, it will be copied to the other days
		        if(newEvent.getDays().contains("M")){
		            weeklyCalJFrame.setMondayEvents(newEvent,colorIndex);
		        }
		        if(newEvent.getDays().substring(0, 2).contains("T")){
		            weeklyCalJFrame.setTuesdayEvents(newEvent,colorIndex);
		        }
		        if(newEvent.getDays().contains("W")){
		            weeklyCalJFrame.setWednesdayEvents(newEvent,colorIndex);
		        }
		        if(newEvent.getDays().contains("Th")){
		            weeklyCalJFrame.setThursdayEvents(newEvent,colorIndex);
		        }
		        if(newEvent.getDays().contains("F")){
		            weeklyCalJFrame.setFridayEvents(newEvent,colorIndex);
		        }
		        
		    	// close dialog box on click of CreateEvent Button
		    	AddClassDialog.this.setVisible(false);        
			}
		});
		
		dialogPanel.add(addClassLabel);
		dialogPanel.add(addClassList);
		dialogPanel.add(addClassButton);
		
		this.add(dialogPanel);
	}
}
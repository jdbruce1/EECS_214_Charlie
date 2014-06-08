
package scheduleproject;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Schedule class abstracts a collection of events and is the class passed to
 * the GUI. Contains a name of the schedule as a string, an array of events, and
 * the number of events on the schedule. Can be serialized in order to save and
 * load schedules into the application
 * 
 * Implements Serializable
 * 
 * @author jacobbruce
 */
@SuppressWarnings("serial")
public class Schedule implements java.io.Serializable{
	private static final Logger logger = Logger.getLogger(Schedule.class.getName());

	protected String name;
	protected Events[] events;
	int numEvents;
        
        /**
         * Default constructor for a Schedule. Takes no arguments and initializes
         * name to empty string, an empty array of events, and 0 as the number of
         * events
         */
	public Schedule(){
		name = "";
		events = new Events[30];
		numEvents = 0;
	}
        
        /**
         * Schedule constructor if only the name of the schedule is known. Initializes
         * array of events to be empty and number of events to 0
         * 
         * @param n a string representing the name of the schedule
         */
	public Schedule(String n) {
		name = n;
		events = new Events[30];
		numEvents = 0;
	}
        
        /**
         * Schedule constructor if the name and events are known.
         * 
         * @param n a string representing the name of the schedule
         * @param e an array of Events
         */
	public Schedule(String n, Events[] e){
		name = n;
		System.arraycopy(e, numEvents, e, numEvents, e.length);
		numEvents = e.length + 1;
	}
        /**
         * Renames the schedule
         * 
         * @param n the name of the schedule as a string
         */
	public void setName(String n){
		name = n;
	}

        /**
         * Getter method for the Events in the schedule
         * 
         * @return the array of Events
         */
	public Events[] getEvents(){
		return events;
	}
        
        /**
         * Getter method for the name of the schedule
         * 
         * @return the name of the schedule as a string
         */
	public String getName(){
		return name;
	}
        
        /**
         * Getter method for the number of events in the schedule
         * 
         * @return the number of events in the Events array as an int
         */
	public int getNumber(){
		return numEvents;
	}
        
        /**
         * Deletes an event based off the index of the event in the array of Events
         * 
         * @param index the index, as an int, of the event to be deleted
         */
	public void deleteEvent(int index){    

		for(int i = index; i<numEvents; i++){
			events[i]=events[i+1];

		}
		numEvents--; //   Now one less event than previously before method call

	}
        
        /**
         * Deletes the entire array of Events contained in the schedule
         */
	public void clearCalendar(){   // Clears all events from the calendar
		/*for(int i =0; i<numEvents;i++){
             events[i] = null;
         }
         numEvents = 0;
		 */

		events = new Events[30];
		numEvents = 0;
	}
        
        /**
         * Adds a new event in chronological order by day and start hour. Events
         * array is the array implementation of an ordered list
         * 
         * @param e the event to be added
         */
	public void addEvent(Events e){ 
		Events listElement;
		int location = 0;

		while(location < numEvents){
			listElement = (Events) events[location];
			if(listElement.compareTo(e) < 0){
				location ++;
			}
			else{
				break;
			}
		}

		for(int index = numEvents; index > location; index --){
			events[index] = events[index - 1];
		}

		events[location] = e;
		numEvents++;
	}

        /**
         * Adds the new event in order of adding, an unsorted list
         * 
         * @param e the event to be added
         */
	public void addEventSeq(Events e){      
		events[numEvents] = e;
		numEvents ++;
	}
        
        /**
         * Getter method for accessing a single event by its index in the events 
         * array
         * 
         * @param index the index of the event as an int
         * @return the event at the specified index
         */
	public Events getEventByIndex(int index){
		return events[index];
	}
        
        /**
         * Searches the events array for an event with the specified name
         * 
         * @throws RuntimeException if the name of the event does not exist
         * @param s the name of the event to be retrieved as a string
         * @return the event with the specified name
         */
	public Events getEventByName (String s){
		for( int i = 0; i< numEvents; i++){
			if(events[i].getName().equals(s)){
				return events[i];
			}

		}
		throw new RuntimeException("There is no event with this name.");
	}
        /**
         * Overloads the toString method for the schedule class
         * 
         * @return the list of events in the schedule as a string
         */
	@Override
	public String toString(){

		if(numEvents == 0){
			return "\nThe schedule " + name + " doesn't have any events in it.\n";
		}

		String output = "\nThe schedule " + name + " consists of the following events:\n";
		for(int i = 0;i<numEvents;i++){
			output += events[i].toString();
		}

		return output;
	}
        
        /**
         * Adds the events from two schedules together in a new schedule
         * 
         * @param other one of the schedules to be added
         * @return a schedule containing the events of this schedule and other schedule
         */
	public Schedule merge(Schedule other){      // Adds two schedules together.
		Schedule combo = new Schedule(this.name + " and " + other.getName());

		for(int i = 0; i<numEvents; i++){   // Add all of the events from the first schedule
			combo.addEvent(events[i]);
		}

		for(int j = 0; j<other.getNumber(); j++){
			combo.addEvent(other.getEventByIndex(j));
		}

		return combo;
	}
        
        /**
         * Inverts a schedule to find the free time from it. Creates events where
         * there is free time and removes events when that time is occupied
         * 
         * @return a schedule with the free time as Events
         */
	public Schedule invert(){  

		// Finds free time given a schedule

		Schedule freeTime = new Schedule("Free time from the schedule " + this.name);
		Events nextEvent;
		String day = ""; 
		int index;
		int nowMinutes;

		for(int i = 1; i<6; i++){
			switch(i){
			case 1:
				day = "M";
				break;
			case 2:
				day = "TU";
				break;
			case 3:
				day = "W";
				break;
			case 4:
				day = "TH";
				break;
			case 5:
				day = "F";
				break;           
			}

			int duration;

			nowMinutes = 360;
			index = 0;

			while(nowMinutes < 1320){

				// If there is none, make a new free time event from the current time ending at 22.

				if(index == numEvents){
					duration = 1320 - nowMinutes;
					freeTime.addEventSeq(new Events("Free", day, nowMinutes / 60, nowMinutes % 60, duration));
					break;
				}

				// Look at the next thing in the list

				nextEvent = events[index];

				// If it's not on the right day, ignore it

				if(nextEvent.occursOnDay(day)){

					// If its start time is before the current time

					if(nextEvent.getTime() < nowMinutes){
						// If its end time is before the current time, ignore it

						// If its end time is after the current time, jump to that end time

						if(nextEvent.getEnd() > nowMinutes){
							nowMinutes = nextEvent.getEnd();
						}
					}

					// If its start time is the current time, jump to its end time

					else if(nextEvent.getTime() == nowMinutes){
						nowMinutes = nextEvent.getEnd();
					}

					// If its start time is after the current time

					else{
						// Make a new free time event starting at the current time (on the current day) and ending at the start time of the next thing
						freeTime.addEventSeq(new Events("Free",day, nowMinutes/60, nowMinutes % 60, nextEvent.getTime() - nowMinutes));
						// Then jump to the end time of the next thing
						nowMinutes = nextEvent.getEnd();
					}   
				}
				index++;  
			}   
		}
		return freeTime;  
	} 

        /**
         * Merges two schedules, then inverts them, to find the time they're both free.
         * 
         * @param other the schedule to be compared to this schedule
         * @return a schedule containing the free time shared in both schedules
         */
	public Schedule bothFree(Schedule other){   
		Schedule s = this.merge(other);
		s = s.invert();
		return s;
	}

	/**
         * Serializes a schedule and outputs it to specified file.
         * 
         * @param fileName the file name as a string
         */
	public void serialize(String fileName){
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(this);
			out.close();

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			out = new ObjectOutputStream(bos);
			out.writeObject(this);
		}catch(IOException e){
		}finally{
			try{
				out.close();
			}catch(Exception e){
			}
		}
	}

	/**
         * Gets serialized schedule from specified file
         * 
         * @param fileName the name of the serialized schedule
         * @return the deserialized schedule as a Schedule object
         */
	public static Schedule deserialize (String fileName){
		ObjectInputStream in = null;
		try{
			FileInputStream door = new FileInputStream(fileName);
			in = new ObjectInputStream(door);
			Schedule x = new Schedule();
			x = (Schedule) in.readObject();
			return x;
		}
		catch(IOException e){
			logger.log(Level.WARNING, e.getStackTrace().toString());
			Schedule g = new Schedule();
			return g;
		}
		catch(ClassNotFoundException e){
			logger.log(Level.WARNING, e.getStackTrace().toString());
			Schedule g = new Schedule();
			return g;
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				logger.log(Level.WARNING, e.getStackTrace().toString());
			}
		}
	}
}

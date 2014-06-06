
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
 *
 * @author jacobbruce
 */
@SuppressWarnings("serial")
public class Schedule implements java.io.Serializable{
	private static final Logger logger = Logger.getLogger(Schedule.class.getName());

	protected String name;
	protected Events[] events;
	int numEvents;

	public Schedule(){
		name = "";
		events = new Events[30];
		numEvents = 0;
	}

	public Schedule(String n) {
		name = n;
		events = new Events[30];
		numEvents = 0;
	}

	public Schedule(String n, Events[] e){
		name = n;
		System.arraycopy(e, numEvents, e, numEvents, e.length);
		numEvents = e.length + 1;
	}

	public void setName(String n){
		name = n;
	}

	public Events[] getEvents(){
		return events;
	}

	public String getName(){
		return name;
	}

	public int getNumber(){
		return numEvents;
	}

	public void deleteEvent(int index){    // Deletes the indicated event by index.

		for(int i = index; i<numEvents; i++){
			events[i]=events[i+1];

		}
		numEvents--; //   Now one less event than previously before method call

	}

	public void clearCalendar(){   // Clears all events from the calendar
		/*for(int i =0; i<numEvents;i++){
             events[i] = null;
         }
         numEvents = 0;
		 */

		events = new Events[30];
		numEvents = 0;
	}

	public void addEvent(Events e){ // Adds the new event in time order (into an ordered list by time)
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

	public void addEventSeq(Events e){      // Adds the new event in order of adding, an unsorted list
		events[numEvents] = e;
		numEvents ++;
	}

	public Events getEventByIndex(int index){
		return events[index];
	}

	public Events getEventByName (String s){
		for( int i = 0; i< numEvents; i++){
			if(events[i].getName().equals(s)){
				return events[i];
			}

		}
		throw new RuntimeException("There is no event with this name.");
	}

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

	public Schedule invert(){       // Inverts a schedule to find the free time from it

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

	public Schedule bothFree(Schedule other){   // Merges two schedules, then inverts them, to find the time they're both free.
		Schedule s = this.merge(other);
		s = s.invert();
		return s;
	}

	// Serializes object and outputs it to specified file.
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

	// Gets serialized schedule from specified file and returns it
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

package scheduleproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Austin
 */
public class CourseTokenizer {

	/**
	 * @return the array list of events 
	 */
	public static ArrayList<Events> parseCourses() {
		// read the text file and store as an array
		BufferedReader in = null;
		List<String> script = new ArrayList<String>();
		try {
			//TODO this may cause issues in the future. the fallCourses.txt file must be in the main project folder 
			in = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/fallCourses.txt"));
			String read = null;
			while ((read = in.readLine()) != null) {
				read = in.readLine();
				if (read != null){
					String[] splited = read.split("\\$|\\|");
					for (String part : splited) {
						//System.out.println(part);
						if (!part.equals(""))
							script.add(part);
					}
				};
			}
		} catch (IOException e) {
			System.out.println("The following error was generated: " + e);
			e.printStackTrace();
		} finally {
			try {
				in.close();
			}catch (Exception e) {
				System.out.println("The following error was generated: " + e);
				e.printStackTrace();
			}
		}
		// parse the input array to create the list of actual classes
		ArrayList<Events> classArray = new ArrayList<Events>();
		for (int k = 0; k < (script.size()/4)-2; k++){
			// parse the text for event data
			String name = script.get(k*4);
			String days = script.get(k*4+1);
			String time = script.get(k*4+3);
			int colon = time.indexOf(":");
			Integer hours = Integer.parseInt(time.substring(0, colon));
			Integer minutes = Integer.parseInt(time.substring(colon+1));
			Integer duration = Integer.parseInt(script.get(k*4+2));
			classArray.add(new Events(name, days, hours, minutes, duration));
		};       
		return classArray;
	}
}

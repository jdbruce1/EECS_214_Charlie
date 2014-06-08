

package scheduleproject;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;



/**
 * Serialization class provide the methods for saving and loading schedules as
 * files
 * 
 * @author mihir
 */
public class Serialization {
    
    private String filename;
    
    public Serialization(){
        filename = "";
     
        
    }
    
    /**
     * Serializes schedule and outputs it to specified file
     * 
     * @param fileName the name of the output file as a string
     * @param s1 the schedule to be serialized 
     */
    public void serialize(String fileName, Schedule s1){    // 
        try{    
        filename = fileName;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(s1);
            out.close();
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bos);
            out.writeObject(s1);
            out.close();
            
            byte[] buf = bos.toByteArray();
        } catch(IOException e){
        }
        
    }
        
    /**
     * Gets serialized schedule from specified file and returns it
     * 
     * @param fileName the name of the file containing a serialized schedule
     * @return the serialized schedule as an schedule object
     */
    public Schedule Deserialize (String fileName){  
    try{
            FileInputStream door = new FileInputStream(fileName);
            ObjectInputStream reader = new ObjectInputStream(door);
            Schedule x = new Schedule();
            x = (Schedule) reader.readObject();
            return x;
        }
        catch(IOException e){
            e.printStackTrace();
            Schedule g = new Schedule();
            return g;
        }
        catch(ClassNotFoundException a){
            a.printStackTrace();
            Schedule g = new Schedule();
            return g;
        }

    }
}
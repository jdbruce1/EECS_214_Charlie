/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduleproject;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;



/**
 *
 * @author mihir
 */
public class Serialization {
    
    private String filename;
    
    public Serialization(){
        filename = "";
     
        
    }
    
    public void serialize(String fileName, Schedule s1){    // Serializes object and outputs it to specified file.
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
        


    public Schedule Deserialize (String fileName){  // Gets serialized schedule from specified file and returns it
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
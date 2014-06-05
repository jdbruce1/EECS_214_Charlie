package scheduleproject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Austin
 */
public class courseTokenizer {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<ArrayList<String>> main(String[] args) {
        // TODO code application logic here
        //FileInputStream fileInputStream = null;
        //InputStreamReader inputStreamReader = null;
        //BufferedReader bufferedReader = null;
        
        //String[] result = "this is a test".split("\\s");
        //for (int x=0; x<result.length; x++)
        //System.out.println(result[x]);
        
        BufferedReader in = null;
        List<String> script = new ArrayList<String>();
        try {
        in = new BufferedReader(new FileReader("fallCourses.txt"));
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
        System.out.println("There was a problem: " + e);
        e.printStackTrace();
    } finally {
        try {
            in.close();
        } catch (Exception e) {
        }
    }
        
        System.out.println(script);
        
        // Creates the list of actual inputs to be pushed onto the queue
        ArrayList<ArrayList<String>> inputToQueue = new ArrayList<ArrayList<String>>();
        for (int k = 0; k < (script.size()/4)-2; k++){
            ArrayList<String> individualInput = new ArrayList<String>();
            individualInput.add(script.get(k*4));
            individualInput.add(script.get(k*4+1));
            individualInput.add(script.get(k*4+2));
            individualInput.add(script.get(k*4+3));
            inputToQueue.add(individualInput);
            //inputToQueue.add(inputs.get(k*4)+" "+inputs.get((k*4)+1)+" "+
                    //inputs.get(k*4+2)+" "+inputs.get(k*4+3));
            //if (inputs.get(k*4) == "line")
                // PUSH INPUTTOQUEUE.GET(K) TO LINE QUEUE
            //else if (inputs.get(k*4) == "media")
                // PUSH INPUTTOQUEUE.GET(K) TO MEDIA QUEUE
        };
        
        return inputToQueue;
    
}
}


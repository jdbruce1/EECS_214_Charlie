package scheduleproject;

/**
 *
 * @author jacobbruce
 */
public class ScheduleProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeClass test = new TimeClass(5, 30, 60);
        System.out.println("Time 1 is:" + test);
        test.setTime(6, 0, 120);
        System.out.println("Time 1 is:" + test);
        
        TimeClass test2 = new TimeClass(7, 15, 60);
        System.out.println("Time 2 is:" + test2);
        
        TimeClass test3 = new TimeClass(11, 30, 120);
        System.out.println("Time 3 is:" + test3);
        
        TimeClass test4 = new TimeClass(12, 30, 180);
        System.out.println("Time 4 is:" + test4);
        
        TimeClass test5 = new TimeClass(11, 30, 300);
        System.out.println("Time 5 is:" + test5);
        
        System.out.println("Times 1 and 2 conflict?\n" + test.compareTo(test2));
        System.out.println("Times 1 and 3 conflict?\n" + test.compareTo(test3));
        System.out.println("Times 2 and 4 conflict?\n" + test2.compareTo(test4));
        System.out.println("Times 3 and 4 conflict?\n" + test3.compareTo(test4));
        System.out.println("Times 4 and 5 conflict?\n" + test4.compareTo(test5));
        System.out.println("Times 5 and 4 conflict?\n" + test5.compareTo(test4));
        
        Events event1 = new Events("Practice", "MTUW", 15, 0, 180);
        System.out.println(event1);
        
        Course course1 = new Course("Data Structures", "MWF", 11, 0, 60, "Rahimi", "214","EECS");
        System.out.println(course1);
        
        Schedule mySchedule = new Schedule("Jacob's Schedule");
        mySchedule.addEvent(event1);
        mySchedule.addEvent(course1);
        
        mySchedule.addEvent(new Course("Fundamentals of Solid State Engineering", "MTUWF", 9, 0, 60, "Aydin", "223", "EECS"));
        mySchedule.addEvent(new Course("Introduction to AI", "MWF", 10, 0, 60, "Downey", "348", "EECS"));
        mySchedule.addEvent(new Course("Fundamentals of Electromagnetics", "MTUWF", 13, 0, 60, "Taflove", "224", "EECS"));
        mySchedule.addEvent(new Course("Solid State Lab","TH",15,0,180,"Cui","223","EECS"));
        
        System.out.println(mySchedule);

        //mySchedule.build();
        
        Schedule jacobsFree = mySchedule.invert();
        
        System.out.println(jacobsFree);
        
        Schedule evansSchedule = new Schedule("Evan's Schedule");
        evansSchedule.addEvent(new Course("Separations", "MTUWF", 9, 0, 60, "Snurr", "212", "CHEM_ENG"));
        evansSchedule.addEvent(new Course("Waves", "MWTHF", 11, 0, 60, "Brown", "135-3", "PHYSICS"));
        evansSchedule.addEvent(new Course("Life Cycle Assessment", "TUF", 14, 0, 90, "Masonet", "395", "CHEM_ENG"));
        evansSchedule.addEvent(new Course("Sustainability", "TUTH", 15, 30, 90, "Faculty", "230", "ISEN"));
        evansSchedule.addEvent(new Course("Physics Lab", "M",14,0,60,"TA","135-3","Physics"));
        
        System.out.println(evansSchedule);
        
        Schedule bothFree = mySchedule.bothFree(evansSchedule);
        
        System.out.println(bothFree);
        
    }
    
}

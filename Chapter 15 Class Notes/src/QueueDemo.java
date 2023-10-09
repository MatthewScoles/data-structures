import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a priint queue of strings (using linked lists)
        Queue<String> jobs = new LinkedList<>();

        // add jobs

        jobs.add("Joe: 'Expense Report 2023' ");
        jobs.add("Jeff: 'Construction Building 8' ");


        //print

        System.out.println("Printing: "+ jobs.remove());
    
        jobs.add("Ethan: 'Homework' ");
        jobs.add("Nate: 'Data Analysis' ");
        jobs.add("Jeff: 'Construction Building 9' ");

        System.out.println("Printing: "+ jobs.remove());

        while(jobs.size() > 0){
            System.out.println("Printing: "+ jobs.remove());
        }
    }

}
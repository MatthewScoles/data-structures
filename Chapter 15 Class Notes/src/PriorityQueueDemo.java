import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Create a priority queue of to-do items
        // WorkOrder has a message ID that is used to determine priority
        // A Priority queue can only store comparable objects

        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3, "Water Dog"));
        toDo.add(new WorkOrder(78, "Do HomeWork"));
        toDo.add(new WorkOrder(1, "Sleep"));
        toDo.add(new WorkOrder(1, "Play video games"));

        System.out.println(toDo);

        while(toDo.size() > 0){
            System.out.println(toDo.remove());
        }
    }
}

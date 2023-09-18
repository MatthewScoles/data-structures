import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */

    public static void reverse(LinkedList<String> strings)
    {   int count = strings.size();
        String name1 = "";
        String name2 = "";

        ListIterator<String> i1 = strings.listIterator(); 
        ListIterator<String> i2 = strings.listIterator(); 

        while(i2.hasNext()){
            i2.next();
        }

        for (int i = 0; strings.size()/2> i; i++){
           name1 = i1.next();
           name2 = i2.previous();
           i1.set(name2);
           i2.set(name1);
        }
    }
}
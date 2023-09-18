import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList,string. staff = new LinkedList<>();

        staff.addlast("Diana");
        staff.addlast("Harry");
        staff.addlast("Romeo");
        staff.addlast("Tom");
        // The list is currently DHRT

        /*
        * THe listIterator method creates a new list iterator that is
        positioned at the head of the list. The "|" is used to represent the iterator position 
        *
        */

       ListIterator<String> iterator = staff.listIterator(); //DHRT
        //The next method advances the iterator to the next element in the list
        iterator.next(); // D|HRT

        //the next method also returns the element that it is passing by.
        String name = iterator.next(); // DH|RT
        System.out.println(name); //Expected Harry

        //The add method for iterators inserts an element at the iterator position. The iterator is then paosition after the element that was added.
        Iterator.add("Juliet"); //DHJ|RT
        Iterator.add("Nina"); //DHJN|RT

        // The remove method remove stjhe lement returned by the last call to next or previous.
        // The remove method can only be called once after calling next or previous, not after add. (Iterator Remove, not list)
        Iterator.next(); 
        Iterator.remove();

        System.out.println(staff);
        //Expected [Diana, Harry Juliet, Nina, Tom]

        Iterator.previous(); //DHJ|NT
        Iterator.set("Albert"); //DHJ|AT

        // The hasNext method returns true if the list contains another element.
        // Often used in the condition of while loops.

        iterator = staff.listIterator(); //Returns the iterator to the beginning |DHJAT
        while (iterator.hasNext())
        {
            String n = iterator.next();
            if(n.equals("Juliet")) //DHJ|AT
                Iterator.remove(); //DH|AT
            
            //DHAT|
        }

        // Enhanced for loops work with linked lists.
        for(String n: staff) {
            System.out.print(n + " ")
        }

        iterator = staff.listIterator();
        while(iterator.hasNext()){
            String n = iterator.next();
            if(n.equals("Harry"))
                //staff.remove("Diana");
        } // Can't Modify a list while iterating through it.

        // Enhanced for loop automatically uses an iterator
        for(String n: staff){
            if(n.equals("Harry"))
                staff.add("Charlie");
                
        }

    }
}

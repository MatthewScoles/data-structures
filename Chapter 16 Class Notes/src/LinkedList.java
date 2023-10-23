import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    //first referes to the first node in this list, if the list is empty then first is null
    private Node first;
     

    /**
        Constructs an empty linked list.
    */
        public LinkedList() {
            this.first = null;
        }


    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */

    // Node.data returns the data that is stored within a Node
        public Object getFirst(){
            if (this.first == null)
                throw new NoSuchElementException(); 
            return this.first.data;
        }



    /**
        Removes the first element in the linked list.
        @return the removed element
    */

        public Object removefirst() {
            if(this.first == null)
                throw new NoSuchElementException();

            Object current = this.first.data;
            this.first = this.first.next;
            return current;

        }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */

        public void addFirst(Object element) {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = this.first;
            this.first = newNode;
        }



    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */

    public ListIterator listIterator() {
        return new LinkedListIterator();
    }
        


    //Class Node
    // Why is this a static class?
    static class Node {
        public Object data;
        public Node next;
    }



   

        
 //implements ListIterator
    class LinkedListIterator implements ListIterator {
      //private data


            private Node position;
            private Node previous;
            private boolean isAfterNext;

            public LinkedListIterator(){
                position = null;
                previous = null;
                isAfterNext = false;
            }

            public Object next() {
                previous = position;
                isAfterNext = true;

                if (position == null) {
                    position = first;
                }
                else
                    position = position.next;
                
                return position.data;
            }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */

        public boolean hasNext() {
            if(position == null){
                return first != null;
            }
            
            return position.next != null;
        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */

            public void add(Object element){
                //check if the iterator is at the start of the list
                if(position == null){
                    addFirst(element);
                    position = first;
                }    
                else {
                    Node newNode = new Node();
                    newNode.data = element;
                    newNode.next = position.next;
                    position.next = newNode;
                    position = newNode;
                }

            }




        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */

            public void remove(){
                if (!isAfterNext) {
                    throw new IllegalStateException();

                }

                if (position == first){
                    removeFirst();
                    position = null;
                }
                else {
                    previous.next = position.next;
                    position = previous;
                }

                isAfterNext = false;
            }





        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
            public void set(Object element) {
                if(!isAfterNext){
                    throw new IllegalStateException();

                }
                position.data = element;
            }

            /* 
             * Goes through the linkedlist counting each connection to 
             * another element until there is no more returning the count/size
             * of the linked list
             */




    }//LinkedListIterator
}//LinkedList

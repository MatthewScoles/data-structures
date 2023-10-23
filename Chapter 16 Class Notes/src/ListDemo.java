/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Preston");
        students.addFirst("Greg");
        students.addFirst("Jeff");
        students.addFirst("David");

        ListIterator iterator = students.listIterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.add("Jimmy");

        students.size();

    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample3.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            Stack<String> HTML = new Stack<>();
            boolean Check = true;
            while(in.hasNext() && Check == true){
                String Tag = in.next();
                if(!Tag.contains("/")){
                    HTML.push(Tag);
                }
                else{
                    if (HTML.peek().substring(1).equals(Tag.substring(2))) {
                        HTML.pop();  } 
                        
                    else {
                        
                        Check = false;
                    }
                }
                System.out.println(HTML);
            }
            if (Check){
                System.out.println("The HTML tags are correctly placed.");
            }
            if(!Check){
                 System.out.println("You did it wrong.");
            }
            
            }


        catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}

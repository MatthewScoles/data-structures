import java.util.*;
import java.io.*;

/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "C:\\Users\\Msscoles\\Desktop\\data-structures\\Chapter 15 Activities\\StringLengthMap\\src\\test1.txt";;
        
        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
             Map<Integer, String> words = new HashMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                // Update the map here
                // Modify Worked Example 15.1
                
                words.put(len, word);
            }
            System.out.println("hi");
            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            int i = 0;
            int count = 0;
            while(count <= words.size()){
                Set<Integer> keys = words.keySet();
                for (Integer key: keys){
                    if(i == key){
                    System.out.println(words.get(key) + " " + key);
                    count++;    
                    }
            }  
             i += 1;
        }

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}

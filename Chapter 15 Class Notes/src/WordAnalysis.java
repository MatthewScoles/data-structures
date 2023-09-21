import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] arg)
        throws FileNotFoundException
    {
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/throughTheLookingGlass.txt");
    
        int count = 0; 

        for (String word: novelWords){
            if (!dictionaryWords.contains(word)){
                System.out.println(word);
            } count++;
            
        }
        System.out.println("There are " + novelWords.size()+" unique words in the novel");
        Iterator<String> iterator = novelWords.iterator();
        while (iterator.hasNext()){
            if (iterator.next().length() <= 3){
                iterator.remove();
            }
        }
        System.out.println("There are " + novelWords.size()+" unique words in the novel");
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        Set<String> words = new HashSet<>();

        Scanner in = new Scanner(new File(filename), "UTF-8");

        in.useDelimiter("[^a-zA-Z]+");

        while( in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }

        return words;
    }
}

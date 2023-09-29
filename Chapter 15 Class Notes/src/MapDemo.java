import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /* The Map interface is generic
         * the first type is the type of the key.
         * the second is the type of the value
         */

         Map<String, Color> favColors = new HashMap<>();

         favColors.put("Hyder", Color.RED);
         favColors.put("Athena", Color.MAGENTA);
         favColors.put("Bavya", Color.BLUE);
         favColors.put("Mitchell", Color.RED);

        // using put for a key that already exists changes the value
         favColors.put("Athena", Color.MAGENTA);

         System.out.println(favColors.get("Athena"));

         //Create a set of the keys in a map.

         Set<String> keys = favColors.keySet();
         for (String key: keys)
         {
            System.out.println(key + "("+key.hashCode() + "): "+favColors.get(key));
            
         }

    }
}

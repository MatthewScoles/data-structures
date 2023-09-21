import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        

        Set<Integer> nums = new HashSet<>();
        int i = 2;
        while(i<=n){
            nums.add(i);
            i++;
        }
        i = 2;
        
            Iterator iterator = nums.iterator();
            while(iterator.hasNext()){
                int x = (int) iterator.next();
                if (x % 2 == 0 || x % 3 == 0 ) {
                    iterator.remove();
                }
            }

            i++;

        System.out.println(nums);





    }
}

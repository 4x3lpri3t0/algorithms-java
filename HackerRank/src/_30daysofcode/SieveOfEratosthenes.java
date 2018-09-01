package _30daysofcode;

import java.util.Vector;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

public class SieveOfEratosthenes {
    static Vector<Integer> simpleSieve(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p < n; p++) {
            // Not changed -> It's prime
            if (prime[p]) {
                // Update multiples of p
                for (int i = p * 2; i <= n; i++) {
                    prime[i] = false;
                }
            }
        }

        Vector<Integer> primes = new Vector<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primes.add(i);
        }

        return primes;
    }

    // Problems with Simple Sieve:
    // When n is large, the Simple Sieve faces following issues:
    // * An array of size Θ(n) may not fit in memory
    // * Not cache friendly even for slightly bigger n
    // (Algorithm traverses the array without locality of reference).
    // https://www.geeksforgeeks.org/segmented-sieve/
    static void segmentedSieve(int n) {
        // Compute primes >= to square root of n using simple sieve
        int limit = (int) (floor(sqrt(n)) + 1);
        Vector<Integer> primes = simpleSieve(limit);

        // Divide the range [0..n-1] in different segments
        // We have chosen segment size as sqrt(n).
        int low = limit;
        int high = 2 * limit;

        // While all segments of range [0..n-1] are not processed,
        // process one segment at a time
        while (low < n) {
            if (high >= n)
                high = n;

            // To mark primes in current range.
            // A value in mark[i] will finally be false if 'i-low'
            // is not a prime, else true.
            boolean[] mark = new boolean[limit + 1];

            for (int i = 0; i < mark.length; i++) {
                mark[i] = true;
            }

            // Use the found primes by simpleSieve() to find
            // primes in current range
            for (int i = 0; i < primes.size(); i++) {
                // Find the minimum number in [low..high] that is
                // a multiple of prime.get(i) (divisible by prime.get(i))
                // E.g., if low is 31 and prime.get() is 3, we start
                // with 33.
                int loLim = (int) (floor(low / primes.get(i)) * primes.get(i));
                if (loLim < low)
                    loLim += primes.get(i);

                /*  Mark multiples of prime.get(i) in [low..high]:
                    We are marking j - low for j, i.e. each number
                    in range [low, high] is mapped to [0, high-low]
                    so if range is [50, 100]  marking 50 corresponds
                    to marking 0, marking 51 corresponds to 1 and
                    so on. In this way we need to allocate space only
                    for range  */
                for (int j = loLim; j < high; j += primes.get(i))
                    mark[j - low] = false;
            }

            // Numbers which are not marked as false are prime
            for (int i = low; i < high; i++)
                if (mark[i - low])
                    out.print(i + "  ");

            // Update low and high for next segment
            low = low + limit;
            high = high + limit;
        }
    }

    public static void main(String args[]) {
        int n = 100;
        out.println("Primes smaller than " + n + ":");
        segmentedSieve(n);
    }
}
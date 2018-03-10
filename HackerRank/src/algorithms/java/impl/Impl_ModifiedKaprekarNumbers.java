package impl; // Delete in HR

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Impl_ModifiedKaprekarNumbers {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Get inputs
        final int P = Integer.parseInt(br.readLine());
        final int Q = Integer.parseInt(br.readLine());

        // Create array to store Kaprekar Numbers
        ArrayList<Integer> kaprekars = new ArrayList<>();

        // Find Kaprekar numbers between P and Q (inclusive)
        for (int i = P; i <= Q; ++i) {
            long squared = (long)i * i;

            // Number of digits in a number: https://stackoverflow.com/questions/39357584
            double digitCount = Math.floor(Math.log10(i)) + 1;

            int divisor = (int)Math.pow(10, digitCount);

            int left = (int)Math.floor(squared / divisor);
            int right = (int)(squared % divisor);
            if (left + right == i) {
                kaprekars.add(i);
            }
        }

        // Output Kaprekar numbers
        StringBuffer sb = new StringBuffer();
        for (Integer k : kaprekars) {
            sb.append(k).append(" ");
        }

        if (kaprekars.size() == 0) {
            System.out.print("INVALID RANGE");
        } else {
            System.out.print(sb);
        }
    }
}
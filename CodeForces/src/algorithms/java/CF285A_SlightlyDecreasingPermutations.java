import java.io.*;
import java.util.*;

public class CF285A_SlightlyDecreasingPermutations {
    private void solve() {
        int n = readInt();
        int k = readInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        // Reversing only the last k digits
        ArrayUtils.reverse(arr, n - k - 1, n - 1);

        for (int i = 0; i < n; i++) {
            if (i > 0)
                out.print(" ");
            out.print(arr[i]);
        }
    }

    static class ArrayUtils {
        public static <T> void reverse(T[] arr, int from, int to) {
            int i = from;
            int j = to;
            while (i < j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        new CF285A_SlightlyDecreasingPermutations().run();
    }

    private void run() {
        try {
            init();
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    private void init() throws IOException {
        String filename = "";
        if (filename.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        }
    }

    private String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }

        return tok.nextToken();
    }

    private int readInt() {
        return Integer.parseInt(readString());
    }
}
import java.io.*;
import java.util.*;

/*
If there are no 0s, you can never construct a multiple of 90.

If there is at least one 0, then check if there are less than nine 5s.
In that case the answer is 0.

Else the answer is 5 (printed to the greatest possible multiple of 9 possible)
followed by all the zeroes.
*/

public class CF352A_JeffAndDigits {
    private void solve() {
        int n = readInt();
        int a[] = new int[6];

        while (n-- > 0)
            a[readInt()]++;

        if (a[0] == 0)
            out.println(-1);
        else if (a[5] < 9)
            out.println(0);
        else {
            for (int i = 0; i < a[5] / 9; i++)
                out.print("555555555");
            for (int i = 0; i < a[0]; i++)
                out.print("0");
        }
    }

    public static void main(String[] args) {
        new CF352A_JeffAndDigits().run();
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
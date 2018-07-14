import java.io.*;
import java.util.*;

/*
val = |x| + |y|
Then first point is (val * sign(x), 0)
second — (0, val * sign(y))

Swap points if needed according to statement.

Let's see why this is the answer.
Conditions x ≠ 0 and y ≠ 0 give us that one point is on X-axis,
and the other on Y-axis.

Let's see how it works for x > 0 and y > 0.
Other cases can be proved in similar way.
We need to show, that (x, y) belongs to our triangle (including it's borders).
In fact (x, y) belongs to segment, connecting (x + y, 0) with (0, x + y).
Line through (x + y, 0) and (0, x + y) is Y =  - X + x + y.
Using coordinates (x, y) in this equation proves the statement.
*/

public class CF336A_VasilyTheBearAndTriangle {
    private void solve() {
        long x = readLong();
        long y = readLong();

        long a = Math.abs(x) + Math.abs(y);
        a *= Long.signum(x);

        long b = Math.abs(x) + Math.abs(y);
        b *= Long.signum(y);

        if (a > 0)
            out.println(0 + " " + b + " " + a + " " + 0);
        else
            out.println(a + " " + 0 + " 0 " + b);
    }

    public static void main(String[] args) {
        new CF336A_VasilyTheBearAndTriangle().run();
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

    private long readLong() {
        return Long.parseLong(readString());
    }

    private double readDouble() {
        return Double.parseDouble(readString());
    }
}
import java.io.*;
import java.util.StringTokenizer;

// Two pointers

public class CF279B_Books_alt1 {
    private void solve() {
        int n = readInt();
        int t = readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = readInt();

        int next = 0, count = 0;
        for (int i = 0; i < n; i++) {
            // Substract next number from t
            t -= a[i];

            if (t >= 0) {
                int period = i - next + 1;

                // Max period of possible reads ??
                count = Math.max(count, period);
            } else {
                // Add next book ??
                t += a[next];
                next++;
            }
        }

        out.println(count);
    }

    public static void main(String[] args) {
        new CF279B_Books_alt1().run();
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
}
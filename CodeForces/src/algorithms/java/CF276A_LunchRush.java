import java.io.*;
import java.util.*;

public class CF276A_LunchRush {
    private void solve() {
        int n = readInt();
        int k = readInt();

        int maxJoy = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int f = readInt();
            int t = readInt();

            if (t > k)
                f -= (t - k);
            maxJoy = Math.max(maxJoy, f);
        }

        out.println(maxJoy);
    }

    public static void main(String[] args) {
        new CF276A_LunchRush().run();
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
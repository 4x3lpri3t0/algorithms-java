import java.io.*;
import java.util.*;

public class CF43A_Football {
    private void solve() {
        int n = readInt();
        String cur = readString();
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            String next = readString();
            if (next.equals(cur)) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                cur = next;
                count = 1;
            }
        }

        out.println(cur);
    }

    public static void main(String[] args) {
        new CF43A_Football().run();
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
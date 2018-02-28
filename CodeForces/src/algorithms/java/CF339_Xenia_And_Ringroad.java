import java.io.*;
import java.util.*;

public class CF339_Xenia_And_Ringroad {
    private void solve() {
        int n = readInt();
        int m = readInt();

        int previous = 1;
        long moves = 0;
        while (m-- > 0) {
            int current = readInt();

            if (current >= previous)
                moves += current - previous;
            else
                moves += (n - previous) + current;

            previous = current;
        }

        out.println(moves);
    }

    public static void main(String[] args) {
        new CF339_Xenia_And_Ringroad().run();
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
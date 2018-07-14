import java.io.*;
import java.util.*;

public class CF104A_Blackjack {
    private void solve() {
        int n = readInt();
        int ret;

        if (n < 11) {
            ret = 0;
        } else if (n > 21) {
            ret = 0;
        } else if (n == 20) {
            // 12 cards (3 picture cards * 4 suits) can give 10 points,
            // but the Queen of Spades is already on the table so = 11
            // And then add the four 10s
            ret = 15;
        } else if (n == 21) {
            ret = 4; // 4 aces (played as 11)
        } else if (n == 11) {
            ret = 4; // 4 aces (played as 1)
        } else {
            ret = 4;
        }

        out.println(ret);
    }

    public static void main(String[] args) {
        new CF104A_Blackjack().run();
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
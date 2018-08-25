import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

public class CF1027A_PalindromicTwist {
    private void solve() {
        int n = readInt();

        while (n-- > 0) {
            int len = readInt();
            String s = readString();
            Boolean valid = true;

            int i = 0;
            while (i <= len / 2) {
                char l = s.charAt(i);
                char r = s.charAt(len - 1 - i);

                int dist = abs(l - r);
                if (dist != 2 && dist != 0) {
                    valid = false;
                    break;
                }
                i++;
            }

            if (valid)
                out.println("YES");
            else
                out.println("NO");
        }

    }

    public static void main(String[] args) {
        new CF1027A_PalindromicTwist().run();
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
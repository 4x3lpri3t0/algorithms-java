import java.io.*;
import java.util.*;

public class CF1027B_NumbersOnTheChessboard {
    private void solve() {
        int n = readInt();
        int q = readInt();
        long[][] grid = new long[n][n];
        long counter = 1;

        // Print even places
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j += 2) {
               if ((j + i) % 2 != 0)
                   j++;

                if (j < n) {
                    grid[i][j] = counter;
                    counter++;
                }
            }
        }
        
        // Print odd places
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j += 2) {
                if ((j + i) % 2 == 0)
                    j++;

                if (j < n) {
                    grid[i][j] = counter;
                    counter++;
                }
            }
        }

        while (q-- > 0) {
            int r = readInt();
            int c = readInt();
            out.println(grid[r - 1][c - 1]);
        }
    }

    public static void main(String[] args) {
        new CF1027B_NumbersOnTheChessboard().run();
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
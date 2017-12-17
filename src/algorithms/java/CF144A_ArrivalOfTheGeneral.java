import java.io.*;
import java.util.*;

public class CF144A_ArrivalOfTheGeneral {
    private void solve() {
        int n = readInt();
        int[] A = new int[n];

        // Get the max and min indexes
        int minValue = 100;
        int minIdx = 0;
        int maxValue = 1;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            int cur = readInt();
            A[i] = cur;

            if (cur <= minValue) {
                minValue = cur;
                minIdx = i;
            }

            if (cur > maxValue) {
                maxValue = cur;
                maxIdx = i;
            }
        }

        int result = maxIdx + (n - 1 - minIdx) - (minIdx < maxIdx ? 1 : 0);
        out.println(result);
    }

    public static void main(String[] args) {
        new CF144A_ArrivalOfTheGeneral().run();
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
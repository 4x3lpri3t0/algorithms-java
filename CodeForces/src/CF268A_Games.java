import java.io.*;
import java.util.*;

public class CF268A_Games {
    private void solve() {
        int n = readInt();
        int[] h = new int[n];
        int[] a = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            h[i] = readInt();
            a[i] = readInt();
        }

        for (int i = 0; i < h.length; i++) {
            int curH = h[i];
            for (int j = 0; j < a.length; j++) {
                if (i == j) continue;

                int curA = a[j];
                if (curH == curA)
                    result++;
            }
        }

        out.println(result);
    }

    public static void main(String[] args) {
        new CF268A_Games().run();
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
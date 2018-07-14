import java.io.*;
import java.util.*;

public class CF34B_Sale {
    private void solve() {
        int n = readInt();
        int m = readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
        }

        Arrays.sort(a);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (m == 0 || a[i] >= 0)
                break;
            result += Math.abs(a[i]);
            m--;
        }

        out.println(result);
    }

    public static void main(String[] args) {
        new CF34B_Sale().run();
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
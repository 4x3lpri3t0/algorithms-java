import java.io.*;
import java.util.*;

public class CF955A_Feed_the_Cat {
    private long ceil(long a, long b) {
        if (a % b == 0) return a / b;
        return a / b + 1;
    }

    private void solve() {
        int h = readInt();
        int m = readInt();
        int H = readInt();
        int D = readInt();
        int C = readInt();
        int N = readInt();

        if (h >= 20) {
            out.println(ceil(H, N) * C * 0.8);
        } else {
            int hn = 20 - h - 1;
            int mn = 60 - m;
            int tm = hn * 60 + mn;
            int HH = H + D * tm;
            double a1 = ceil(HH, N) * C * 0.8;
            double a2 = ceil(H, N) * C;

            out.println(Math.min(a1, a2));
        }
    }

    public static void main(String[] args) {
        new CF955A_Feed_the_Cat().run();
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
import java.io.*;
import java.util.*;

public class CF1027B_NumbersOnTheChessboard {
    private void solve() {
        long n = readLong();
        long q = readLong();

        while (q-- > 0) {
            long r = readLong();
            long c = readLong();
            long d = (r - 1) * n + c;
            long ans = 0;

            if ((r % 2 == 0 && c % 2 == 0) || (r % 2 != 0 && c % 2 != 0)) {
                // 1 to ceil(n2/2)
                ans = (d + 1) / 2;
            } else {
                // ceil(n2/2) + 1 to n2
                ans = (n * n) / 2;
                if (n % 2 != 0)
                    ans++;

                ans += (d + 1) / 2;
            }

            out.println(ans);
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
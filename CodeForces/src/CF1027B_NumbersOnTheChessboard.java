import java.io.*;
import java.util.*;

public class CF1027B_NumbersOnTheChessboard {
    private void solve() {
        int n = readInt();
        int q = readInt();

        while (q-- > 0) {
            int r = readInt();
            int c = readInt();
            long ans;
            long d = (r - 1) * n + c;

            if ((r % 2 == 0 && c % 2 == 0) || (r % 2 != 0 && c % 2 != 0)) {
                ans = (d + 1) / 2;
            } else {
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
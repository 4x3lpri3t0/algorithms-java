import java.io.*;
import java.util.*;

public class CF166E_Tetrahedron_alt3 {
    private void solve() {
        int n = readInt();
        long dp[] = new long[n + 1];
        dp[1] = 0;

        if (n > 1) {
            dp[2] = 3;
        }

        for (int x = 3; x <= n; x++) {
            long dpTotal = (2 * dp[x - 1]) + (3 * dp[x - 2]);
            dp[x] = dpTotal % 1000000007;
        }

        out.println(dp[n] % 1000000007);
    }

    public static void main(String[] args) {
        new CF166E_Tetrahedron_alt3().run();
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
}
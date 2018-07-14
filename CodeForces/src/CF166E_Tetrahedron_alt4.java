import java.io.*;
import java.util.*;

public class CF166E_Tetrahedron_alt4 {
    static long mod = 1000000007;
    static long ans[] = new long[10000001];

    private void solve() {
        int n = readInt();

        ans[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0)
                ans[i] = (3 * ans[i - 1] + 3) % mod;
            else
                ans[i] = (3 * ans[i - 1] - 3) % mod;
        }

        out.println(ans[n]);
    }

    public static void main(String[] args) {
        new CF166E_Tetrahedron_alt4().run();
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
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF121A_Lucky_Sum extends PrintWriter {
    public void solve() throws IOException {
        long l = nextInt();
        long r = nextInt();
        long res = 0;
        for (int mask = 2; l <= r; mask++) {
            int t = mask;
            long v = 0;
            long mul = 1;
            while (t > 1) {
                v += (t % 2 == 0 ? 4 : 7) * mul;
                mul *= 10;
                t /= 2;
            }
            long k = Math.min(r, v);
            if (k >= l) {
                res += (k - l + 1) * v;
                l = k + 1;
            }
        }

        println(res);
    }

    BufferedReader in;
    StringTokenizer stok;

    public void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(abs(-1));
        }
    }

    CF121A_Lucky_Sum() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF121A_Lucky_Sum(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF121A_Lucky_Sum().run();
    }

    String next() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int[] nextIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    <T> List<T>[] createAdjacencyList(int countVertex) {
        List<T>[] res = new List[countVertex];
        for (int i = 0; i < countVertex; i++) {
            res[i] = new ArrayList<T>();
        }
        return res;
    }
}
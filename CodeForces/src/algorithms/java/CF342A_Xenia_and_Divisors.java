import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF342A_Xenia_and_Divisors extends PrintWriter {
    public void solve() throws IOException {
        int n = nextInt();
        int[] c = new int[8];
        for (int i = 0; i < n; i++) {
            c[nextInt()]++;
        }

        int c124 = c[4];
        c[1] -= c[4];
        c[2] -= c[4];
        c[4] = 0;

        int c126 = c[2];
        c[1] -= c[2];
        c[6] -= c[2];
        c[2] = 0;

        int c136 = c[3];
        c[1] -= c[3];
        c[6] -= c[3];
        c[3] = 0;

        for (int i : c) {
            if (i != 0) {
                println(-1);
                return;
            }
        }

        if (c124 < 0 || c126 < 0 || c136 < 0) {
            println(-1);
            return;
        }

        for (int i = 0; i < c124; i++) {
            println("1 2 4");
        }
        for (int i = 0; i < c126; i++) {
            println("1 2 6");
        }
        for (int i = 0; i < c136; i++) {
            println("1 3 6");
        }
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

    CF342A_Xenia_and_Divisors() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF342A_Xenia_and_Divisors(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF342A_Xenia_and_Divisors().run();
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
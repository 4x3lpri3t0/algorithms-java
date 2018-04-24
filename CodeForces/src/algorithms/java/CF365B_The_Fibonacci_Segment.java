import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF365B_The_Fibonacci_Segment extends PrintWriter {
    public void solve() throws IOException {
        int n = nextInt();
        if (n == 1) {
            println(1);
            return;
        }

        int longest = 2;
        int[] A = new int[n];

        A[0] = nextInt();
        A[1] = nextInt();
        int current = longest;
        for (int i = 2; i < n; i++) {
            A[i] = nextInt();
            if (A[i] == A[i - 2] + A[i - 1]) {
                current++;
                longest = max(longest, current);
            } else {
                current = 2;
            }
        }

        println(longest);
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

    CF365B_The_Fibonacci_Segment() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF365B_The_Fibonacci_Segment(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF365B_The_Fibonacci_Segment().run();
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
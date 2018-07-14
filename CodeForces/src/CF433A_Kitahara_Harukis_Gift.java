import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF433A_Kitahara_Harukis_Gift extends PrintWriter {
    public void solve() throws IOException {
        int n = nextInt();
        int A = 0;
        int B = 0;

        // Integer because sort with Collections.reverseOrder() can't sort arrays of primitives
        Integer[] apples = nextIntArray(n);
        Arrays.sort(apples, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (A > B)
                B += apples[i];
            else
                A += apples[i];
        }

        println(A == B ? "YES" : "NO");
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

    CF433A_Kitahara_Harukis_Gift() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF433A_Kitahara_Harukis_Gift(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF433A_Kitahara_Harukis_Gift().run();
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

    Integer[] nextIntArray(int len) throws IOException {
        Integer[] a = new Integer[len];
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
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF404A_ValeraAndX extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        char[][] p = new char[n][n];
        for (int i = 0; i < n; i++)
            p[i] = read().toCharArray();

        char c1 = p[0][0];
        char c2 = p[0][1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j || i == (n - 1 - j)) { // First or last
                    if (p[i][j] != c1) {
                        println("NO");
                        return;
                    }
                } else if (p[i][j] != c2) {
                    println("NO");
                    return;
                }

        println(c1 == c2 ? "NO" : "YES");
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

    CF404A_ValeraAndX() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF404A_ValeraAndX(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF404A_ValeraAndX().run();
    }

    String read() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(read());
    }

    long readLong() throws IOException {
        return Long.parseLong(read());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(read());
    }

    int[] readIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = readInt();
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
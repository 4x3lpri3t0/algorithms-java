import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/problemset/problem/353/A
public class CF353A_Domino extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        boolean ok = false; // Is there at least an odd with two non-equal sides?
        int sumLeft = 0, sumRight = 0;

        for (int i = 0; i < n; i++) {
            int left = readInt(), right = readInt();
            sumLeft += left;
            sumRight += right;
            if (left % 2 != right % 2)
                ok = true;
        }

        if (sumLeft % 2 == 0) {
            if (sumRight % 2 == 0) {
                println(0);
            } else { // right odd
                println(-1);
            }
        } else { // left odd
            if (sumRight % 2 == 0) {
                println(-1);
            } else { // right odd
                if (ok)
                    println(1);
                else
                    println(-1);
            }
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

    CF353A_Domino() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF353A_Domino(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF353A_Domino().run();
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
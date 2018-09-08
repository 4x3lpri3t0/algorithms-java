import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/problemset/problem/34/A
public class CF34A_Reconnaissance2 extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int[] A = readIntArray(n);

        int min = Integer.MAX_VALUE;
        int[] idx = new int[]{0, 1};
        int a = A[0];
        for (int i = 1; i < n; i++) {
            int b = A[i];

            if (abs(a - b) < min) {
                min = abs(a - b);
                idx[0] = i;
                idx[1] = i + 1;
            }

            a = b;
        }

        if (abs(A[0] - A[n - 1]) < min) {
            println(1 + " " + n);
        } else {
            println(idx[0] + " " + idx[1]);
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

    CF34A_Reconnaissance2() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF34A_Reconnaissance2().run();
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

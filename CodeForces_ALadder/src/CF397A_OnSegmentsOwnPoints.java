import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/contest/397/problem/A
public class CF397A_OnSegmentsOwnPoints extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();

        boolean[] a = new boolean[101];
        int x = readInt(), y = readInt();
        for (int i = 1; i < n; i++) {
            int l = readInt();
            int r = readInt();
            Arrays.fill(a, l, r, true);
        }

        int cnt = 0;
        for (int i = x; i < y; i++)
            if (!a[i])
                cnt++;

        println(cnt);
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

    CF397A_OnSegmentsOwnPoints() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF397A_OnSegmentsOwnPoints().run();
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
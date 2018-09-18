import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF374A_InnaAndPinkPony extends PrintWriter {
    private static int iMax = Integer.MAX_VALUE;

    private static int get(int x, int y, int a, int b) {
        int ret;
        if (x % a != 0 || y % b != 0)
            ret = iMax;
        else {
            a = x / a;
            b = y / b;
            if ((a & 1) != (b & 1))
                ret = iMax;
            else
                ret = max(a, b);
        }

        return ret;
    }

    private static Boolean good(int x, int dx, int n) {
        if (x > dx) return true;
        return n - x >= dx;
    }

    public void solve() throws IOException {
        int m = readInt(), n = readInt(), i = readInt(), j = readInt(), a = readInt(), b = readInt();
        int ans = iMax;
        ans = min(ans, get(i - 1, j - 1, a, b));
        ans = min(ans, get(i - 1, n - j, a, b));
        ans = min(ans, get(m - i, j - 1, a, b));
        ans = min(ans, get(m - i, n - j, a, b));
        if ((!good(i, a, m) || !good(j, b, n)) && ans != 0) ans = iMax;
        if (ans == iMax)
            println("Poor Inna and pony!");
        else
            println(ans);
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

    CF374A_InnaAndPinkPony() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF374A_InnaAndPinkPony().run();
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
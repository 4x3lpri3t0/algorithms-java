import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// TODO: Breaks with really large numbers
public class CF508B_AntonAndCurrencyYouAllKnow extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        char[] a = Integer.toString(n).toCharArray();
        int len = a.length;
        int val = -1;

        for (int i = 0; i < len; i++) {
            int cur = Integer.valueOf(a[i]);
            if (cur % 2 == 0) {
                char[] b = a.clone();
                b[len - 1] = a[i];
                b[i] = a[len - 1];
                val = max(val, Integer.valueOf(new String(b)));
            }
        }

        println(val);
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

    CF508B_AntonAndCurrencyYouAllKnow() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF508B_AntonAndCurrencyYouAllKnow().run();
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
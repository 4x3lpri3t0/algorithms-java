import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/problemset/problem/508/B
public class CF508B_AntonAndCurrencyYouAllKnow extends PrintWriter {
    static char[] even = new char[]{'0', '2', '4', '6', '8'};

    private static boolean isEven(char c) {
        for (char c1 : even) {
            if (c1 == c) {
                return true;
            }
        }

        return false;
    }

    public void solve() throws IOException {
        char[] n = read().toCharArray();

        int lastEven = -1;
        int last = n[n.length - 1] - '0'; // to int
        for (int i = 0; i < n.length; i++) {
            if (isEven(n[i])) {
                lastEven = i;

                if(last > n[i] - '0') {
                    break;
                }
            }
        }

        if (lastEven != -1) {
            char t = n[lastEven];
            n[lastEven] = n[n.length - 1];
            n[n.length - 1] = t;

            println(new String(n));
            return;
        }

        println("-1");
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
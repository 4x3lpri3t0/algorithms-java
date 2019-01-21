import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class AE1B extends PrintWriter {
    void solve() throws IOException {
        int n = readInt();
        int k = readInt();
        int s = readInt();

        int[] a = readIntArray(n);
        Arrays.sort(a);

        long accum = 0;
        for (int i = n - 1; i >= 0; i--) {
            accum += a[i];

            if (accum >= k * s) {
                print(n - i);
                return;
            }
        }
    }

    BufferedReader in;
    StringTokenizer stok;

    void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(abs(-1));
        }
    }

    AE1B() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new AE1B().run();
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

    int[] readIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = readInt();
        }
        return a;
    }
}
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class ADDREV extends PrintWriter {
    private long reverse(long n) {
        long reversed = 0;
        while (n > 0) {
            long d = n % 10;
            n /= 10;

            reversed *= 10;
            reversed += d;
        }

        return reversed;
    }

    void solve() throws IOException {
        int T = readInt();
        while (T-- > 0) {
            // Reverse n1
            long n1 = reverse(readInt());

            // Reverse n2
            long n2 = reverse(readInt());

            // Sum them up
            long sum = n1 + n2;

            // Reverse total and print it
            println(reverse(sum));
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

    ADDREV() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    ADDREV(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new ADDREV().run();
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

    long[] readLongArray(int len) throws IOException {
        long[] a = new long[len];
        for (int i = 0; i < len; i++) {
            a[i] = readLong();
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
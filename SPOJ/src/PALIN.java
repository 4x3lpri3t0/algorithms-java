import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class PALIN extends PrintWriter {
    void solve() throws IOException {
        int t = readInt();
        while (t-- > 0) {
            String curPal = read();

            // bool evenLength = curPal.length() % 2 == 0;

            // Odd
            //   -> Need to change middle
            //      -> Middle < 9
            //          +1
            //      -> Else:
            //          Need to
            //              0 middle
            //              +1 the neighbors (iteratively until neighbors != 9?)

            println();
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

    PALIN() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    PALIN(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new PALIN().run();
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
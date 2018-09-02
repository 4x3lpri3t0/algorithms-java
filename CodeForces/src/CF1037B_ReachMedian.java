import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1037B_ReachMedian extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int s = readInt();
        int[] a = readIntArray(n);

        Arrays.sort(a);

        int m = n / 2;
        long mid = a[m];

        if (mid == s) {
            println(0);
            return;
        }

        long accum = 0;
        if (mid < s) { // To the right
            for (int i = m; i < n; i++) {
                if (a[i] >= s)
                    break;
                accum += s - a[i];
            }
        } else {
            for (int i = m; i >= 0; i--) {
                if (a[i] <= s)
                    break;
                accum += a[i] - s;
            }
        }

        println(accum);
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

    CF1037B_ReachMedian() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF1037B_ReachMedian(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1037B_ReachMedian().run();
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
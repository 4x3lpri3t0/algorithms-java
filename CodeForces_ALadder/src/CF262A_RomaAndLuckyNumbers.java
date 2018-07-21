import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF262A_RomaAndLuckyNumbers extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int k = readInt();
        int[] A = readIntArray(n);

        int notSoLucky = 0;
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            int luckyCount = 0;

            while (cur > 0 && luckyCount <= k) {
                int d = cur % 10;

                if (d == 4 || d == 7)
                    luckyCount++;

                cur /= 10;
            }

            if (luckyCount <= k)
                notSoLucky++;
        }

        println(notSoLucky);
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

    CF262A_RomaAndLuckyNumbers() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF262A_RomaAndLuckyNumbers(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF262A_RomaAndLuckyNumbers().run();
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
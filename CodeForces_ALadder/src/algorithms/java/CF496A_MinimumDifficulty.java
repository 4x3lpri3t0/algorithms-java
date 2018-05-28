import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF496A_MinimumDifficulty extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int[] a = readIntArray(n);

        int globalMinMax = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) { // Skips
            int localMax = Integer.MIN_VALUE;

            for (int j = 0; j < n - 1; j++) {
                if (j + 1 == i) { // Skip next
                    localMax = max(localMax, a[j + 2] - a[j]);
                } else {
                    localMax = max(localMax, a[j + 1] - a[j]);
                }
            }

            globalMinMax = min(localMax, globalMinMax);
        }

        println(globalMinMax);
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

    CF496A_MinimumDifficulty() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF496A_MinimumDifficulty(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF496A_MinimumDifficulty().run();
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
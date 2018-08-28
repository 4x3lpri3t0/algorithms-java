import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MISERMAN extends PrintWriter {
    void solve() throws IOException {
        int N = readInt();
        int M = readInt();

        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = readIntArray(M);
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                int min = grid[i + 1][j];

                if (j > 0) // Check left
                    min = min(min, grid[i + 1][j - 1]);
                if (j < M - 1) // Check right
                    min = min(min, grid[i + 1][j + 1]);

                grid[i][j] += min;
            }
        }

        // Get min
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            globalMin = min(globalMin, grid[0][i]);
        }

        // Print
        println(globalMin);
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

    MISERMAN() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    MISERMAN(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new MISERMAN().run();
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
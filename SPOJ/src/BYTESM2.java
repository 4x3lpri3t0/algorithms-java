import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class BYTESM2 extends PrintWriter {
    void solve() throws IOException {
        int t = readInt();

        while (t-- > 0) {
            int h = readInt();
            int w = readInt();

            int[][] grid = new int[h + 1][w]; // (Last column: all 0's)
            for (int i = 0; i < h; i++) {
                int[] row = readIntArray(w);
                grid[i] = row;
            }

            // From last row to first:
            //      For digit in row:
            //          sum current digit + max(3 'parents' from lower row)

            for (int i = h - 1; i >= 0; i--) {
                for (int j = 0; j < w; j++) {
                    // Local max
                    int max = grid[i + 1][j]; // center
                    if (j > 0)
                        max = max(max, grid[i + 1][j - 1]); // left
                    if (j < w - 1)
                        max = max(max, grid[i + 1][j + 1]); // right

                    grid[i][j] += max;
                }
            }

            // Print max element from first row
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < w; i++) {
                max = max(max, grid[0][i]);
            }

            println(max);
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

    BYTESM2() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    BYTESM2(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new BYTESM2().run();
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
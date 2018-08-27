import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1028A_FindSquare extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt(); // Rows
        int m = readInt(); // Cols

        int x1 = n, y1 = m, x2 = -1, y2 = -1;
        for (int i = 0; i < n; i++) {
            char[] row = read().toCharArray();
            for (int j = 0; j < m; j++) {
                if (row[j] == 'B') {
                    x1 = min(x1, i);
                    x2 = max(x2, i);

                    y1 = min(y1, j);
                    y2 = max(y2, j);
                }
            }
        }

        println((x1 + x2) / 2 + 1 + " " + ((y1 + y2) / 2 + 1));
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

    CF1028A_FindSquare() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF1028A_FindSquare(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1028A_FindSquare().run();
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
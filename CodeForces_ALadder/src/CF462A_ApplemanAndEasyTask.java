import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// https://codeforces.com/contest/462/problem/A
public class CF462A_ApplemanAndEasyTask extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = read().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int oAdjacent = 0;

                if (i > 0 && matrix[i - 1][j] == 'o')
                    oAdjacent++;
                if (i < n - 1 && matrix[i + 1][j] == 'o')
                    oAdjacent++;
                if (j > 0 && matrix[i][j - 1] == 'o')
                    oAdjacent++;
                if (j < n - 1 && matrix[i][j + 1] == 'o')
                    oAdjacent++;

                if (oAdjacent % 2 != 0) {
                    println("NO");
                    return;
                }
            }
        }

        println("YES");
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

    CF462A_ApplemanAndEasyTask() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF462A_ApplemanAndEasyTask(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF462A_ApplemanAndEasyTask().run();
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
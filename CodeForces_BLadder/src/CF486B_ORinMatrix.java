import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/contest/486/problem/B
// http://codeforces.com/blog/entry/14678
public class CF486B_ORinMatrix extends PrintWriter {
    public void solve() throws IOException {
        int r = readInt();
        int c = readInt();
        int[][] b = new int[r][c];
        int[][] a = new int[r][c];
        for (int[] arr : a) Arrays.fill(arr, 1);

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                b[i][j] = readInt();
                if (b[i][j] == 0) {
                    for (int k = 0; k < r; k++) a[k][j] = 0;
                    for (int k = 0; k < c; k++) a[i][k] = 0;
                }
            }

        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (a[i][j] == 1) {
                    for (int k = 0; k < r; k++) tmp[k][j] = 1;
                    for (int k = 0; k < c; k++) tmp[i][k] = 1;
                }

        if (Arrays.deepEquals(b, tmp)) {
            println("YES");
            for (int i = 0; i < r; i++) {
                StringJoiner sj = new StringJoiner(" ");
                for (int num : a[i]) sj.add("" + num);
                println(sj.toString());
            }
        } else {
            println("NO");
        }
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

    CF486B_ORinMatrix() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF486B_ORinMatrix().run();
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
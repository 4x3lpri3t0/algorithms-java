import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF966B_Battleship extends PrintWriter {
    public void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = next().toCharArray();
        }

        int[][] count = new int[n][n];
        for (int line = 0; line < n; line++) {
            for (int start = 0; start < n; start++) {
                int end = start + k - 1;
                if (end >= n)
                    break;

                boolean ok1 = true;
                boolean ok2 = true;
                for (int i = start; i <= end; i++) {
                    if (map[line][i] == '#')
                        ok1 = false;
                    if (map[i][line] == '#')
                        ok2 = false;
                }

                for (int i = start; i <= end; i++) {
                    if (ok1)
                        count[line][i]++;
                    if (ok2)
                        count[i][line]++;
                }
            }
        }

        int maxI = 0, maxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] > count[maxI][maxJ]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        println((maxI + 1) + " " + (maxJ + 1));
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

    CF966B_Battleship() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF966B_Battleship(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF966B_Battleship().run();
    }

    String next() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int[] nextIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = nextInt();
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
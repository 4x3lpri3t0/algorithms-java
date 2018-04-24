import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF166B_Little_Pigs_and_Wolves extends PrintWriter {
    BufferedReader in;
    StringTokenizer stok;

    boolean check(char[][] a, int i, int j) {
        return i >= 0 && j >= 0 && i < a.length && j < a[0].length && a[i][j] == 'P';
    }

    public void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        char[][] a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] == 'W') {
                    boolean fed = false;
                    fed |= i > 0 && a[i - 1][j] == 'P';
                    fed |= j > 0 && a[i][j - 1] == 'P';
                    fed |= i < n - 1 && a[i + 1][j] == 'P';
                    fed |= j < m - 1 && a[i][j + 1] == 'P';
                    if (fed)
                        ans++;
                }

        println(ans);
    }

    public void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(abs(-1));
        }
    }

    CF166B_Little_Pigs_and_Wolves() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF166B_Little_Pigs_and_Wolves(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        new CF166B_Little_Pigs_and_Wolves().run();
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
}
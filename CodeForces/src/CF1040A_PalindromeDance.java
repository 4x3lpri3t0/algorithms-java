import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1040A_PalindromeDance extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int a = readInt();
        int b = readInt();
        int[] A = readIntArray(n);

        long sum = 0;
        long min = min(a, b);
        for (int i = 0; i < (n + 1) / 2; i++) {
            if (i == n - 1 - i) {
                if (A[i] == 2) {
                    sum += min;
                    continue;
                }
            }

            int l = A[i];
            int r = A[n - 1 - i];

            if (l == 1 && r == 1)
                continue;
            if (l == 0 && r == 0)
                continue;

            if (l == 1) {
                if (r == 2)
                    sum += b;
                else {
                    println(-1);
                    return;
                }
            }
            else if (r == 1) {
                if (l == 2)
                    sum += b;
                else {
                    println(-1);
                    return;
                }
            }
            else if (l == 0) {
                if (r == 2)
                    sum += a;
                else {
                    println(-1);
                    return;
                }
            }
            else if (r == 0) {
                if (l == 2)
                    sum += a;
                else {
                    println(-1);
                    return;
                }
            } else { // 2 and 2
                sum += min * 2;
            }
        }

        println(sum);
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

    CF1040A_PalindromeDance() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF1040A_PalindromeDance(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1040A_PalindromeDance().run();
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
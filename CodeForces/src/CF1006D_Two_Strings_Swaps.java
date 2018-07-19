import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1006D_Two_Strings_Swaps extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        char[] a = read().toCharArray();
        char[] b = read().toCharArray();
        int res = 0;

        if (n % 2 == 1) {
            if (a[n / 2] != b[n / 2])
                res++;
        }

        for (int i = 0; i < n / 2; i++) {
            int i1 = n - 1 - i;
            if (a[i] == a[i1] && b[i] == b[i1])
                continue;
            if (a[i] == b[i] && a[i1] == b[i1])
                continue;
            if (a[i] == b[i1] && a[i1] == b[i])
                continue;
            if (b[i] == b[i1]) {
                res++;
            } else {
                // All four are different
                if (b[i] != a[i] && b[i1] != a[i] && b[i] != a[i1] && b[i1] != a[i1]) {
                    res += 2;
                } else {
                    res++;
                }
            }
        }

        println(res);
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

    CF1006D_Two_Strings_Swaps() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF1006D_Two_Strings_Swaps(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1006D_Two_Strings_Swaps().run();
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
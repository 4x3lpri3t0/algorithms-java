import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF143A_HelpVasilisaTheWise2 extends PrintWriter {
    public void solve() throws IOException {
        int r1 = readInt();
        int r2 = readInt();
        int c1 = readInt();
        int c2 = readInt();
        int d1 = readInt();
        int d2 = readInt();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == i)
                    continue;

                for (int k = 1; k < 10; k++) {
                    if (k == j || k == i)
                        continue;

                    for (int l = 1; l < 10; l++) {
                        if (l == k || l == j || l == i)
                            continue;

                        if (i + j == r1 && l + k == r2 &&
                        i + k == c1 && j + l == c2 &&
                        i + l == d1 && j + k == d2) {
                            println(i + " " + j);
                            println(k + " " + l);
                            return;
                        }
                    }
                }
            }
        }

        println(-1);
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

    CF143A_HelpVasilisaTheWise2() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF143A_HelpVasilisaTheWise2().run();
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
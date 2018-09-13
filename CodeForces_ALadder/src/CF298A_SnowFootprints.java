import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF298A_SnowFootprints extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        String str = read();

        int s = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            char cur = str.charAt(i);
            if (cur == 'R') {
                s = i + 1;
            } else if (cur == 'L') {
                s = i + 1;

                if (t == 0)
                    t = i;
            }
        }

        t = t == 0 ? s + 1: t;

        println(s + " " + t);
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

    CF298A_SnowFootprints() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF298A_SnowFootprints().run();
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
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1046A_AIrobots extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int k = readInt();

        int total = 0;
        // Save as int[3] in ArrayList
        ArrayList<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robots.add(new int[]{readInt(), readInt(), readInt()});
        }

        for (int i = 0; i < n; i++) {
            int[] curi = robots.get(i);
            for (int j = i + 1; j < n; j++) {
                int[] curj = robots.get(j);
                if (curi[0] + curi[1] >= curj[0]
                        && curi[0] - curi[1] <= curj[0]
                        && curj[0] + curj[1] >= curi[0]
                        && curj[0] - curj[1] <= curi[0]
                        && abs(curi[2] - curj[2]) <= k)
                    total++;
            }
        }

        println(total);
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

    CF1046A_AIrobots() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1046A_AIrobots().run();
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

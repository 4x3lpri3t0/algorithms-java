import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF432B_FootballKit extends PrintWriter {

    // mkirsche solution
    public void solve() throws IOException {
        int n = readInt();
        int[] homes = new int[n], aways = new int[n], fs = new int[100001];

        for (int i = 0; i < n; i++) {
            int a = readInt(), b = readInt();
            homes[i] = a;
            aways[i] = b;
            fs[a]++;
        }

        int tot = n - 1;
        for (int i = 0; i < n; i++) {
            println(tot + fs[aways[i]] + " " + (tot - fs[aways[i]]));
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

    CF432B_FootballKit() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF432B_FootballKit().run();
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
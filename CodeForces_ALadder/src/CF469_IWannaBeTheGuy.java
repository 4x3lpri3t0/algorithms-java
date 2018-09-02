import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// https://codeforces.com/contest/469/problem/A
public class CF469_IWannaBeTheGuy extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        boolean[] N = new boolean[n];

        int x = readInt();
        for (int i = 0; i < x; i++) {
            N[readInt() - 1] = true;
        }

        int y = readInt();
        for (int i = 0; i < y; i++) {
            N[readInt() - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!N[i]) {
                println("Oh, my keyboard!");
                return;
            }
        }

        println("I become the guy.");
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

    CF469_IWannaBeTheGuy() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF469_IWannaBeTheGuy(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF469_IWannaBeTheGuy().run();
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
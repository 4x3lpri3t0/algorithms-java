import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/contest/842/problem/A
// http://codeforces.com/blog/entry/54179
public class CF842A_KirillAndTheGame extends PrintWriter {
    public void solve() throws IOException {
        int l = readInt(); // min xp
        int r = readInt(); // max xp
        int x = readInt(); // min cost
        int y = readInt(); // max cost
        int k = readInt();

        // We want to know if there is a potion such that
        // exp and cost meet the following condition: exp / cost == k
        // We can iterate on cost from x to y and check
        // that exp = k·cost is not less than l and not greater than r
        for (long b = x; b <= y; b++) {
            if (l <= b * k && r >= b * k) {
                println("YES");
                return;
            }
        }
        println("NO");
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

    CF842A_KirillAndTheGame() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF842A_KirillAndTheGame().run();
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
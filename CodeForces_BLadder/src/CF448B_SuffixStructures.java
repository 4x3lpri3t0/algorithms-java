import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/problemset/problem/448/B
// https://codeforces.com/blog/entry/13042
public class CF448B_SuffixStructures extends PrintWriter {
    static boolean isSub(char[] c, char[] s) {
        int cur = 0;
        for (char e : s) {
            if (cur < c.length && c[cur] == e) ++cur;
        }
        return cur == c.length;
    }

    public void solve() throws IOException {
        char[] c = read().toCharArray();
        char[] t = read().toCharArray();
        boolean ok1 = isSub(t, c);
        Arrays.sort(c);
        Arrays.sort(t);
        boolean ok2 = Arrays.equals(c, t);
        boolean ok3 = isSub(t, c);
        if (!ok3) { // Not even sorted is subsequence
            println("need tree");
        } else if (ok1) {
            println("automaton");
        } else if (ok2) {
            println("array");
        } else {
            println("both");
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

    CF448B_SuffixStructures() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF448B_SuffixStructures().run();
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
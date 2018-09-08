import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// codeforces.com/contest/358/problem/A
public class CF358A_DimaAndContinuousLine extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int pre = readInt();
        ArrayList<int[]> segs = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int cur = readInt();
            int[] curSeg = new int[]{Math.min(pre, cur), Math.max(pre, cur)};
            for (int[] seg : segs) {
                if (curSeg[1] > seg[0]
                        && curSeg[0] < seg[1]
                        && (curSeg[0] < seg[0] || curSeg[1] > seg[1])
                        && (curSeg[0] > seg[0] || curSeg[1] < seg[1])) {
                    println("yes");
                    return;
                }
            }
            segs.add(curSeg);
            pre = cur;
        }
        println("no");
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

    CF358A_DimaAndContinuousLine() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF358A_DimaAndContinuousLine().run();
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

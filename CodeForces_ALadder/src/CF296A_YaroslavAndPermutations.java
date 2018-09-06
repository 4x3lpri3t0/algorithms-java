import java.io.*;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class CF296A_YaroslavAndPermutations extends PrintWriter {
    public void solve() throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        int n = readInt();
        for (int i = 0; i < n; i++) {
            int cur = readInt();
            if (!map.containsKey(cur))
                map.put(cur, 0);

            int iValue = map.get(cur) + 1;

            map.put(cur, iValue);

            if (iValue > (n + 1) / 2) {
                print("NO");
                return;
            }
        }

        print("YES");
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

    CF296A_YaroslavAndPermutations() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF296A_YaroslavAndPermutations(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF296A_YaroslavAndPermutations().run();
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
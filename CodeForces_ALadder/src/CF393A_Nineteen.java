import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF393A_Nineteen extends PrintWriter {
    public void solve() throws IOException {
        int[] CTR = new int[26];
        String line = read();
        for (int i = 0, L = line.length(); i < L; i++)
            CTR[line.charAt(i) - 'a']++;

        int ans = line.length();
        ans = min(ans, (CTR['n' - 'a'] - 1) / 2); // nineteenineteen case
        ans = min(ans, CTR['e' - 'a'] / 3);
        ans = min(ans, CTR['i' - 'a']);
        ans = min(ans, CTR['t' - 'a']);

        println(ans);
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

    CF393A_Nineteen() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF393A_Nineteen().run();
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
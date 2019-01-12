import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF447B_DZYLovesStrings extends PrintWriter {
    public void solve() throws IOException {
        String s = read();
        int k = readInt();
        int[] alphabet = new int[26];
        int max = Integer.MIN_VALUE;

        // Store actual value of char: alphabet i * position value
        // Also keep max
        for (int i = 0; i < 26; i++) {
            alphabet[i] = readInt();
            max = max(max, alphabet[i]);
        }

        int accum = 0;
        for (int i = 1; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            int idx = cur - 97; // Convert to alphabet index
            accum += alphabet[idx] * i;
        }

        for (int i = s.length() + 1; i <= s.length() + k; i++) {
            accum += max * i;
        }

        println(accum);
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

    CF447B_DZYLovesStrings() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF447B_DZYLovesStrings().run();
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
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF108A_PalindromicTimes extends PrintWriter {
    public void solve() throws IOException {
        String s = read();
        String h = s.substring(0, 2);
        String m = s.substring(3, 5);
        int rev = Integer.parseInt(h.charAt(1) + "" + h.charAt(0));
        if (rev > Integer.parseInt(m) && rev < 60) {
            println(h + ":" + h.charAt(1) + "" + h.charAt(0));
            return;
        }

        int hx = Integer.parseInt(h) + 1;

        h = hx + "";

        if (hx < 10)
            h = "0" + hx;
        if (hx > 15 && hx < 20)
            h = "20";
        if (hx == 24)
            h = "00";
        if (hx > 5 && hx < 10)
            h = "10";

        println(h + ":" + h.charAt(1) + "" + h.charAt(0));
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

    CF108A_PalindromicTimes() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF108A_PalindromicTimes().run();
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
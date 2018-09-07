import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF376A_Lever extends PrintWriter {
    private long sumDigits(String str) {
        long sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '=')
                continue;

            sum += (str.charAt(i) - '0') * (i + 1);
        }

        return sum;
    }

    public void solve() throws IOException {
        String str = read();
        int idx = str.indexOf('^');
        String l = str.substring(0, idx);
        String r = str.substring(idx + 1);

        long total = sumDigits(new StringBuilder(l).reverse().toString()) - sumDigits(r);
        if (total == 0)
            println("balance");
        else if (total > 0)
            println("left");
        else
            println("right");
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

    CF376A_Lever() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF376A_Lever().run();
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
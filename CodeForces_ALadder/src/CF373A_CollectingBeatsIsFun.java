import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF373A_CollectingBeatsIsFun extends PrintWriter {
    public void solve() throws IOException {
        int kk = readInt() * 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            String row = read();
            for (int j = 0; j < 4; j++) {
                char cur = row.charAt(j);
                if (cur == '.')
                    continue;

                int digit = cur - '0';
                if (!map.containsKey(digit))
                    map.put(digit, 0);
                int newVal = map.get(digit) + 1;

                if (newVal > kk) {
                    println("NO");
                    return;
                }

                map.put(digit, newVal);
            }
        }

        println("YES");
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

    CF373A_CollectingBeatsIsFun() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF373A_CollectingBeatsIsFun().run();
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

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF302A_EugenyAndArray extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int m = readInt();

        int posCount = 0;
        int negCount = 0;
        for (int i = 0; i < n; i++) {
            if (readInt() == 1) {
                posCount++;
            } else {
                negCount++;
            }
        }

        int pairs = min(posCount, negCount);

        for (int i = 0; i < m; i++) {
            int positions = abs(readInt() - readInt()) + 1;
            if (positions % 2 == 1) {
                println(0);
            } else if (positions <= pairs * 2) {
                println(1);
            } else {
                println(0);
            }
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

    CF302A_EugenyAndArray() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF302A_EugenyAndArray().run();
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

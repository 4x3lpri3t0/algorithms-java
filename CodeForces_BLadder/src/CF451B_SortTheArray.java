import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF451B_SortTheArray extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int[] a = readIntArray(n);

        // Get segment
        int start = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] >= a[i + 1]) {
                start = i;

                // Go from current to last unsorted to get end of segment
                while (i < n - 1 && a[i] >= a[i + 1]) {
                    i++;
                }
                end = i;
            }
        }

        // Sort segment
        for (int i = 0; i <= (end - start) / 2; i++) {
            int tmp = a[start + i];
            a[start + i] = a[end - i];
            a[end - i] = tmp;
        }

        // Is it fully ordered now?
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                println("no");
                return;
            }
        }

        println("yes\n" + (start + 1) + " " + (end + 1));
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

    CF451B_SortTheArray() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF451B_SortTheArray().run();
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
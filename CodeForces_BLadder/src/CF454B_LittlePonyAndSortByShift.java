import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF454B_LittlePonyAndSortByShift extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int arr[] = readIntArray(n);
        int id = -1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                id = i + 1;
                break;
            }
        }

        if (id == -1) {
            println(0);
            return;
        }

        for (int i = id; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                println(-1);
                return;
            }
        }

        if (arr[0] < arr[n - 1]) {
            println(-1);
            return;
        }

        println(n - id);
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

    CF454B_LittlePonyAndSortByShift() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF454B_LittlePonyAndSortByShift().run();
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
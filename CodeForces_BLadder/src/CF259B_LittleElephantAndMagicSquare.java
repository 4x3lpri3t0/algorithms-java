import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/contest/259/problem/B
public class CF259B_LittleElephantAndMagicSquare extends PrintWriter {
    public void solve() throws IOException {
        int[] arr = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = readInt();
            total += arr[i];
        }

        // Because we got input from 6 numbers, we divide / 2
        // so we get a third of the final solution.
        total /= 2;

        arr[0] = total - (arr[1] + arr[2]);
        arr[4] = total - (arr[3] + arr[5]);
        arr[8] = total - (arr[7] + arr[6]);
        for (int i = 0; i < 9; i++) {
            println(arr[i]);
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

    CF259B_LittleElephantAndMagicSquare() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF259B_LittleElephantAndMagicSquare().run();
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
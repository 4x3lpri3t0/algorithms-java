import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// https://codeforces.com/problemset/problem/378/A
public class CF378A_PlayingWithDice extends PrintWriter {
    public void solve() throws IOException {
        int a = readInt();
        int b = readInt();

        int[] ans = new int[3];
        for (int i = 1; i <= 6; i++) {
            if (abs(a - i) < abs(b - i)) {
                ans[0]++;
            } else if (abs(a - i) == abs(b - i)) {
                ans[1]++;
            } else {
                ans[2]++;
            }
        }

        print(ans[0] + " " + ans[1] + " " + ans[2]);
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

    CF378A_PlayingWithDice() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF378A_PlayingWithDice(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF378A_PlayingWithDice().run();
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
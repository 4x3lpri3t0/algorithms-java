import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// https://codeforces.com/problemset/problem/152/A
public class CF152A_Marks extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        String[] grades = new String[n];
        boolean[] succStudents = new boolean[n];

        for (int i = 0; i < n; i++) {
            grades[i] = read();
        }

        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                int cur = grades[j].charAt(i);
                max = max(max, cur);
            }

            for (int j = 0; j < n; j++) {
                int cur = grades[j].charAt(i);
                if (cur == max)
                    succStudents[j] = true;
            }
        }

        int total = 0;
        for (boolean successful : succStudents) {
            if (successful)
                total++;
        }

        println(total);
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

    CF152A_Marks() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF152A_Marks(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF152A_Marks().run();
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
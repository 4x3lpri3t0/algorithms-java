import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF459A_Pashmak_and_Garden extends PrintWriter {
    public void solve() throws IOException {
        int x1 = nextInt();
        int y1 = nextInt();
        int x2 = nextInt();
        int y2 = nextInt();

        if (x1 == x2) {
            int nx = (x1 + abs(y1 - y2));
            println(nx + " " + y1 + " " + nx + " " + y2);
        } else if (y1 == y2) {
            int ny = y1 + abs(x1 - x2);
            println(x1 + " " + ny + " " + x2 + " " + ny);
        } else if (abs(x1 - x2) == abs(y1 - y2)) {
            println(x1 + " " + y2 + " " + x2 + " " + y1);
        } else {
            println(-1);
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

    CF459A_Pashmak_and_Garden() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF459A_Pashmak_and_Garden(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF459A_Pashmak_and_Garden().run();
    }

    String next() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int[] nextIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = nextInt();
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
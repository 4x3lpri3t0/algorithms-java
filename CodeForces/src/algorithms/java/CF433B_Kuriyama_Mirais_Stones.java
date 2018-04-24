import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF433B_Kuriyama_Mirais_Stones extends PrintWriter {
    public void solve() throws IOException {
        int n = nextInt();
        long[] A = new long[n + 1];
        long[] B = new long[n + 1];
        long accum = 0;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            B[i] = a;
            accum += a;
            A[i + 1] = accum;
        }

        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            B[i + 1] += B[i];
        }

        int m = nextInt();
        for (int i = 0; i < m; i++) {
            int type = nextInt();
            int l = nextInt();
            int r = nextInt();
            println(type == 1 ? A[r] - A[l - 1] : B[r] - B[l - 1]);
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

    CF433B_Kuriyama_Mirais_Stones() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF433B_Kuriyama_Mirais_Stones(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF433B_Kuriyama_Mirais_Stones().run();
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

    <T> List<T>[] createAdjacencyList(int countVertex) {
        List<T>[] res = new List[countVertex];
        for (int i = 0; i < countVertex; i++) {
            res[i] = new ArrayList<T>();
        }
        return res;
    }
}
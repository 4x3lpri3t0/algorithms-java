import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF165A_SupercentralPoint extends PrintWriter {
    public void solve() throws IOException {
        int N = readInt();

        int[] X = new int[N];
        int[] Y = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = readInt();
            Y[i] = readInt();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            boolean cnt[] = new boolean[4];
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if (X[j] == X[i] && Y[j] < Y[i])
                        cnt[0] = true;
                    else if (X[j] == X[i] && Y[j] > Y[i])
                        cnt[1] = true;
                    else if (Y[j] == Y[i] && X[j] < X[i])
                        cnt[2] = true;
                    else if (Y[j] == Y[i] && X[j] > X[i])
                        cnt[3] = true;
                }
            }

            if (cnt[0] && cnt[1] && cnt[2] && cnt[3])
                ans++;
        }

        println(ans);
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

    CF165A_SupercentralPoint() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF165A_SupercentralPoint(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF165A_SupercentralPoint().run();
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
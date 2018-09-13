import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF370A_RookBishopAndKing extends PrintWriter {
    public void solve() throws IOException {
        int r1 = readInt();
        int c1 = readInt();
        int r2 = readInt();
        int c2 = readInt();

        // Rook
        int a1 = (r1 == r2 || c1 == c2) ? 1 : 2;

        // Bishop
        int a2 = 0;
        if ((r1 + c1) % 2 == (r2 + c2) % 2) {
            a2 = abs(r1 - r2) == abs(c1 - c2) ? 1 : 2;
        }

        // King
        int a3 = max(abs(r1 - r2), abs(c1 - c2));

        printf("%d %d %d", a1, a2, a3);
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

    CF370A_RookBishopAndKing() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF370A_RookBishopAndKing().run();
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
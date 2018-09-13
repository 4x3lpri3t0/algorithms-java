import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF279A_PointOnSpiral extends PrintWriter {
    public void solve() throws IOException {
        int x = readInt();
        int y = readInt();
        int ans = 0;
        int cx = 0;
        int cy = 0;
        int[] dx = new int[]{1, 0, -2, 0};
        int[] dy = new int[]{0, 1, 0, -2};
        for (int i = 0; ; i = (i + 1) % 4, ans++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            // signum extracts the sign of the Integer
            dx[i] += Integer.signum(dx[i]) * 2;
            dy[i] += Integer.signum(dy[i]) * 2;
            if (cx == nx && cx == x && y >= min(cy, ny) && y <= max(cy, ny)) {
                println(ans);
                return;
            }

            if (cy == ny && cy == y && x >= min(cx, nx) && x <= max(cx, nx)) {
                println(ans);
                return;
            }

            cx = nx;
            cy = ny;
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

    CF279A_PointOnSpiral() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF279A_PointOnSpiral().run();
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
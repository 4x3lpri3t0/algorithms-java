import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF18A_Triangle extends PrintWriter {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point subtract(Point other) {
            return new Point(x - other.x, y - other.y);
        }

        int dotProduct(Point other) {
            return x * other.x + y * other.y;
        }

        int vectorProduct(Point other) {
            return x * other.y - y * other.x;
        }
    }

    boolean isRight(Point[] p) {
        for (int i = 0; i < 3; i++) {
            Point a = p[i];
            Point b = p[(i + 1) % 3];
            Point c = p[(i + 2) % 3];
            Point vb = b.subtract(a);
            Point vc = c.subtract(a);
            if (vb.dotProduct(vc) == 0 && vb.vectorProduct(vc) != 0) {
                return true;
            }
        }
        return false;
    }

    public void solve() throws IOException {
        Point[] p = new Point[3];
        for (int i = 0; i < 3; i++) {
            p[i] = new Point(readInt(), readInt());
        }

        if (isRight(p)) {
            println("RIGHT");
            return;
        }

        int[] d = {0, -1, 0, 1};
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 4; k++) {
                Point a = new Point(p[i].x + d[k], p[i].y + d[k + 1 & 3]);
                Point b = p[(i + 1) % 3];
                Point c = p[(i + 2) % 3];
                if (isRight(new Point[]{a, b, c})) {
                    println("ALMOST");
                    return;
                }
            }
        }

        println("NEITHER");
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

    CF18A_Triangle() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF18A_Triangle().run();
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
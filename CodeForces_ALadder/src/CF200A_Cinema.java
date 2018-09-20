import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/blog/entry/4769
// http://codeforces.com/problemset/problem/200/A
public class CF200A_Cinema extends PrintWriter {
    public void solve() throws IOException {
        int N = readInt();
        int M = readInt();
        int K = readInt();

        boolean[][] marked = new boolean[N + 1][M + 1];
        int[][] dists = new int[N + 1][M + 1];
        int[][] u = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < K; i++) {
            int rRow = readInt();
            int rCol = readInt();

            int dRow, dCol;
            int dist = dists[rRow][rCol];

            for (int j = 0; j < 8; j++) {
                int t1 = rRow + u[j][0];
                int t2 = rCol + u[j][1];
                if (0 >= t1 || t1 >= N + 1 || 0 >= t2 || t2 >= M + 1)
                    continue;

                dist = max(dist, dists[t1][t2] - (abs(u[j][0]) + abs(u[j][1])));
            }

            boolean flag = false;
            while (true) {
                for (dRow = -dist; dRow <= dist; dRow++) {
                    int row = rRow + dRow;
                    dCol = dist - abs(dRow);
                    int col = rCol - dCol;

                    if (row >= 1 && row <= N && col >= 1 && col <= M && !marked[row][col]) {
                        marked[row][col] = true;

                        println(row + " " + col);

                        flag = true;
                        break;
                    }

                    col = rCol + dCol;
                    if (row >= 1 && row <= N && col >= 1 && col <= M && !marked[row][col]) {
                        marked[row][col] = true;

                        println(row + " " + col);

                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    break;
                }

                dist++;
            }

            dists[rRow][rCol] = dist;
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

    CF200A_Cinema() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF200A_Cinema().run();
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
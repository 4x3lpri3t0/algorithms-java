import java.io.*;
import java.util.*;

import static java.lang.Math.*;

/*
If first player can't make first move
(table is too small and plate doesn't fit it, i.e. 2r > min(a, b)),
second player wins. Else first player wins.
Winning strategy for first player: place first plate to the center
of table. After that he symmetrically reflects moves of second player
with respect to center of table. If second player has move,
first player has symmetrical move, too. If not, first player won.
*/
// http://codeforces.com/problemset/problem/197/A
public class CF197A_PlateGame extends PrintWriter {
    public void solve() throws IOException {
        int a = readInt();
        int b = readInt();
        int d = readInt() * 2;

        println(min(a, b) >= d ? "First" : "Second");
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

    CF197A_PlateGame() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF197A_PlateGame().run();
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
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF510A_FoxAndSnake extends PrintWriter {
    public void solve() throws IOException {
        int row = readInt();
        int col = readInt();
        char snake = '#';
        char empty = '.';

        StringBuilder full = new StringBuilder();
        StringBuilder skipped = new StringBuilder();
        for (int i = 0; i < col; i++)
            full.append(snake);
        for (int i = 1; i < col; i++)
            skipped.append(empty);

        for (int i = 1; i <= row; i++) {
            if (i % 2 == 1)
                println(full);
            else if (i % 4 == 0)
                println(snake + skipped.toString());
            else
                println(skipped.toString() + snake);
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

    CF510A_FoxAndSnake() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF510A_FoxAndSnake(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF510A_FoxAndSnake().run();
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
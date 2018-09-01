import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF439A_DevuTheSingerAndChuruTheJoker extends PrintWriter {
    private static int JOKE_LENGTH = 5;

    public void solve() throws IOException {
        int n = readInt();
        int d = readInt();

        d -= 10 * (n - 1);
        for (int i = 0; i < n; i++) {
            d -= readInt();
        }

        if (d < 0) {
            println(-1);
        } else {
            int sum = (n - 1) * 2;
            sum += d / 5;
            println(sum);
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

    CF439A_DevuTheSingerAndChuruTheJoker() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF439A_DevuTheSingerAndChuruTheJoker(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF439A_DevuTheSingerAndChuruTheJoker().run();
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
}
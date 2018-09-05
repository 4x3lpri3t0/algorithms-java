import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1040B_ShashlikCooking extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int k = readInt();

        if (k == 0) {
            println(n);
            for (int i = 1; i <= n; i++) {
                print(i + " ");
            }
            return;
        }

        int mink = k + 1;
        int maxk = k * 2 + 1;

        if (n <= maxk) {
            println(1);
            println(n / 2 + 1);
            return;
        }

        for (int i = 0; i + mink <= maxk; i++) {
            int rest = n - (i + mink);
            int mod = rest % maxk;
            if (mod > 0 && mod < mink) {
                continue;
            }

            // print turns
            if (mod == 0)
                println(1 + rest / maxk);
            else
                println(2 + rest / maxk); // ???

            // print formation
            for (int j = i; j < n; j += k * 2 + 1) {
                print((j + 1) + " ");
            }

            return;
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

    CF1040B_ShashlikCooking() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF1040B_ShashlikCooking(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1040B_ShashlikCooking().run();
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
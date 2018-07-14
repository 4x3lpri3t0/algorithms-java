import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF313A_AIlyaAndBankAccount extends PrintWriter {
    private int getWithoutLast(int n) {
        return n / 10;
    }

    private int getWithoutPrevToLast(int n) {
        int lastDigit = n % 10;

        return ((n / 100) * 10) + lastDigit;
    }

    public void solve() throws IOException {
        int n = readInt();

        if (n >= 0) {
            println(n);
        } else {
            println(max(getWithoutLast(n), getWithoutPrevToLast(n)));
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

    CF313A_AIlyaAndBankAccount() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF313A_AIlyaAndBankAccount(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF313A_AIlyaAndBankAccount().run();
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
import java.io.*;
import java.math.BigInteger;
import java.util.Locale;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FCTRL2 extends PrintWriter {
    private BigInteger computeFactorial(long n) {
        if (n < 3)
            return BigInteger.valueOf(n);

        BigInteger bigi = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            bigi = bigi.multiply(BigInteger.valueOf(i));
        }

        return bigi;
    }

    void solve() throws IOException {
        int T = readInt();

        while (T-- > 0) {
            println(computeFactorial(readInt()));
        }
    }

    BufferedReader in;
    StringTokenizer stok;

    void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(abs(-1));
        }
    }

    FCTRL2() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new FCTRL2().run();
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
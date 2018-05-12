import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class CF966C_Greedy_Arkady extends PrintWriter {
    long INF = Long.MAX_VALUE;

    long careMul(long x, long y) {
        BigInteger bi = BigInteger.valueOf(x).multiply(BigInteger.valueOf(y));
        if (bi.compareTo(BigInteger.valueOf(INF)) <= 0) {
            return bi.longValue();
        }
        return INF;
    }

    private long bestAnswer(long n, long k, long m, long d, long x) {
        if (x <= 0)
            return -1;

        if (x > m)
            return -1;

        long mul = careMul(x, k);
        long full = n / mul;

        long rem = n % mul;

        long next = rem / x;

        long me = full + (next == 0 ? 0 : 1);
        if (me > d) return -1;
        return me * x;
    }

    private long clever(long n, long k, long m, long d) {
        long bestAnswer = 0;
        bestAnswer = m;

        for (int cycles = 1; cycles <= d; cycles++) {
            {
                BigInteger x = BigInteger.valueOf(n).divide(BigInteger.valueOf(cycles).multiply(BigInteger.valueOf(k)));

                long xx = Math.min(m, x.longValue());
                bestAnswer = Math.max(bestAnswer, bestAnswer(n, k, m, d, xx));
            }
            {
                BigInteger x = BigInteger.valueOf(n).divide(BigInteger.valueOf(cycles).multiply(BigInteger.valueOf(k)).add(BigInteger.ONE));
                long xx = Math.min(m, x.longValue());
                bestAnswer = Math.max(bestAnswer, bestAnswer(n, k, m, d, xx));
            }
        }

        return bestAnswer;
    }

    public void solve() throws IOException {
        long n = nextLong();
        long k = nextLong();
        long M = nextLong();
        long D = nextLong();

        println(clever(n, k, M, D));
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

    CF966C_Greedy_Arkady() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF966C_Greedy_Arkady(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF966C_Greedy_Arkady().run();
    }

    String next() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int[] nextIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = nextInt();
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
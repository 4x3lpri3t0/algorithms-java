import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/problemset/problem/230/B
public class CF230B_T_primes extends PrintWriter {
    public boolean[] sieveEratosthenes(int range) {
        boolean isPrime[] = new boolean[range + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(range); i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= range; j++)
                    isPrime[i * j] = false;
            }
        }

        return isPrime;
    }

    // Only squares of prime numbers are T-primes
    public void solve() throws IOException {
        int n = readInt();
        boolean b[] = sieveEratosthenes(1000000);
        while (n-- > 0) {
            long a = readLong();
            long check = (long) Math.sqrt(a);
            if (check * check != a) {
                println("NO");
                continue;
            }
            println(b[(int) check] ? "YES" : "NO");
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

    CF230B_T_primes() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF230B_T_primes().run();
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
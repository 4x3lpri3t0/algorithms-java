import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF230B_Tprimes extends PrintWriter {
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

    public void solve() throws IOException {
        int n = nextInt();
        boolean b[] = sieveEratosthenes(1000000);
        while (n-- > 0) {
            long a = nextLong();
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

    CF230B_Tprimes() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF230B_Tprimes(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF230B_Tprimes().run();
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
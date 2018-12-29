import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF478B_RandomTeams extends PrintWriter {
    long countPairs(long n) {
        return (n - 1) * n / 2; // teamSize = 5, return 4 + 3 + 2 + 1
    }

    public void solve() throws IOException {
        int n = readInt();
        int m = readInt();

        // Divide in discrete groups to get minimum amount of pairs possible
        long mod = n % m;
        long eachTeam = n / m;
        long min = (eachTeam * (eachTeam - 1) * m) / 2; // ???
        min += eachTeam * mod;

        // Remove units to get biggest combinatorics graph possible
        long max = countPairs(n - m + 1);

        println(min + " " + max);
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

    CF478B_RandomTeams() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF478B_RandomTeams().run();
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
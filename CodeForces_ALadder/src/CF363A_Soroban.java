import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF363A_Soroban extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();

        do {
            int d = n % 10;

            if (d >= 5) {
                print("-O|");
                d -= 5;
            } else {
                print("O-|");
            }

            if (d == 0)
                print("-OOOO");
            else if (d == 1)
                print("O-OOO");
            else if (d == 2)
                print("OO-OO");
            else if (d == 3)
                print("OOO-O");
            else // (d == 4)
                print("OOOO-");

            n /= 10;
            println();
        } while (n > 0);
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

    CF363A_Soroban() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF363A_Soroban().run();
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
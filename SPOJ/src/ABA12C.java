import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/*
=== Simplified description ===

A boy has 'N' friends and for them he has to buy 'K' kgs of apples. He goes to shop and finds that there are unlimited
number of boxes of apples for each of 1kg , 2 kg , 3kg , ... K kgs .

These 1 ,2 ,.. ,K kgs boxes have prices attached to them. Prices are integers between -1 to 1000.
'-1' price means he cannot buy that very kg box right now as it is currently not available.

The problem is to choose boxes in such way that total weight = K and total price is as minimum as possible.
He can choose multiple boxes of any weight. Also , Though we take 'N' in input , no where we need this 'N'.

INPUT:

N K

prices of those 1,2,.. k kg boxes respectively

(if available is present in infinite amount; -1 price denote that kg box is not available )

OUTPUT:

Minimum price; or -1 if no solution exists
*/

public class ABA12C extends PrintWriter {
    void solve() throws IOException {
        int N = readInt(); // Not used
        int K = readInt();
        int[] prices = readIntArray(K);

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

    ABA12C() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new ABA12C().run();
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
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/contest/305/problem/A
public class CF305A_StrangeAddition extends PrintWriter {
    public void solve() throws IOException {
        int k = readInt();
        int[] d = readIntArray(k);
        String res = "";

        int count = 0;
        int temp = -1;
        boolean unitFound = false;
        boolean decFound = false;

        for (int i = 0; i < k; i++) {
            int cur = d[i];

            if (cur == 0 || cur == 100) {
                count++;
                res += cur + " ";
            } else if (!unitFound && cur <= 9) {
                count++;
                res += cur + " ";
                unitFound = true;
            } else if (!decFound && cur % 10 == 0) {
                count++;
                res += cur + " ";
                decFound = true;
            } else {
                temp = cur;
            }
        }

        if (!unitFound && !decFound && temp != -1) {
            count++;
            res += temp;
        }

        println(count);
        print(res);
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

    CF305A_StrangeAddition() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF305A_StrangeAddition().run();
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
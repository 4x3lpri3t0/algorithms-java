import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF350A_TL extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        int[] nArray = readIntArray(n);
        int[] mArray = readIntArray(m);

        int maxN = Integer.MIN_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = nArray[i];
            minN = min(minN, cur);
            maxN = max(maxN, cur);
        }

        int minM = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int cur = mArray[i];
            minM = min(minM, cur);
        }

        for(int i = maxN; i < minM; i++){
            if(2 * minN <= i){
                println(i);
                return;
            }
        }

        println(-1);
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

    CF350A_TL() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF350A_TL(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF350A_TL().run();
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
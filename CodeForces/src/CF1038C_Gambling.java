import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1038C_Gambling extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        Integer[] A = readIntArray(n);
        Integer[] B = readIntArray(n);

        Arrays.sort(A);
        Arrays.sort(B);

        Stack<Integer> s1 = new Stack<>();
        s1.addAll(Arrays.asList(A));
        Stack<Integer> s2 = new Stack<>();
        s2.addAll(Arrays.asList(B));

        long score1 = 0;
        long score2 = 0;

        while (!s1.empty() || !s2.empty()) {
            int a = s1.size() == 0 ? 0 : s1.peek();
            int b = s2.size() == 0 ? 0 : s2.peek();

            if (a > b) {
                score1 += s1.pop();
            } else { // b >= a
                s2.pop();
            }

            a = s1.size() == 0 ? 0 : s1.peek();
            b = s2.size() == 0 ? 0 : s2.peek();

            if (b > a) {
                score2 += s2.pop();
            } else { // a >= b
                s1.pop();
            }
        }

        println(score1 - score2);
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

    CF1038C_Gambling() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1038C_Gambling().run();
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

    Integer[] readIntArray(int len) throws IOException {
        Integer[] a = new Integer[len];
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
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF490A_TeamOlympiad extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        Stack<Integer> t1 = new Stack<Integer>();
        Stack<Integer> t2 = new Stack<Integer>();
        Stack<Integer> t3 = new Stack<Integer>();

        int[] t = new int[3];
        for (int i = 0; i < n; i++) {
            int cur = readInt();
            t[cur - 1]++;

            if (cur == 1) {
                t1.push(i + 1);
            } else if (cur == 2) {
                t2.push(i + 1);
            } else {
                t3.push(i + 1);
            }
        }

        int teams = min(t[0], min(t[1], t[2]));

        println(teams);

        for (int i = 0; i < teams; i++) {
            println(t1.pop() + " " + t2.pop() + " " + t3.pop());
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

    CF490A_TeamOlympiad() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF490A_TeamOlympiad(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF490A_TeamOlympiad().run();
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
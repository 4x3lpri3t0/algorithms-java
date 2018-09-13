import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/contest/194/problem/A
public class CF194A_Exams extends PrintWriter {
    public void solve() throws IOException {
        // Notice that 2n ≤ k ≤ 5n.
        // If k < 3n author has to get 2 on some exams
        // (There are 3n - k such exams and that's the answer).
        // If 3n ≤ k author will pass all exams (answer is 0).

        println(max(0, 3 * readInt() - readInt()));
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

    CF194A_Exams() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF194A_Exams().run();
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
}
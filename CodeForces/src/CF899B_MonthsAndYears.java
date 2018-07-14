import java.io.*;
import java.util.*;

public class CF899B_MonthsAndYears {
    void solve() throws Exception {
        long n = readLong();
        String months = "3128313031303131303130313128313031303131303130313128313031303131303130313128313031303131303130313129313031303131303130313128313031303131303130313128";
        String toCheck = "";
        for (int i = 0; i < n; i++) {
            toCheck += readString();
        }

        out.println(months.contains(toCheck) ? "YES" : "NO");
    }

    public static void main(String[] args) throws Exception {
        new CF899B_MonthsAndYears().run();
    }

    public void run() {
        try {
            init();
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws IOException {
        String filename = "";
        if (filename.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        }
    }

    String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }

        return tok.nextToken();
    }

    int readInt() {
        return Integer.parseInt(readString());
    }

    long readLong() {
        return Long.parseLong(readString());
    }

    double readDouble() {
        return Double.parseDouble(readString());
    }
}
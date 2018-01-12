import java.io.*;
import java.util.*;

public class CF266B_QueueAtTheSchool {
    private void solve() {
        int n = readInt();
        int t = readInt();
        StringBuffer q = new StringBuffer(readString());

        for (int i = 0; i < t; i++) {
            for (int p = 0; p < n - 1; p++) {
                if (q.charAt(p) == 'B' && q.charAt(p + 1) == 'G') {
                    char temp = q.charAt(p);
                    q.setCharAt(p, q.charAt(p + 1));
                    q.setCharAt(p + 1, temp);

                    p++;
                }
            }
        }

        out.println(q);
    }

    public static void main(String[] args) {
        new CF266B_QueueAtTheSchool().run();
    }

    private void run() {
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

    private void init() throws IOException {
        String filename = "";
        if (filename.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        }
    }

    private String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }

        return tok.nextToken();
    }

    private int readInt() {
        return Integer.parseInt(readString());
    }

    private long readLong() {
        return Long.parseLong(readString());
    }

    private double readDouble() {
        return Double.parseDouble(readString());
    }
}
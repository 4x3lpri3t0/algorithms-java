import java.io.*;
import java.util.*;

public class CF907A_MashaAndBears {
    private void solve() {
        int a1 = readInt();
        int a2 = readInt();
        int a3 = readInt();
        int m = readInt();

        if (2 * a3 >= m) {
            out.println(2 * a1);
            out.println(2 * a2);
            out.println(2 * a3);
        } else { // a3 < m && 2
            out.println(-1);
        }
    }

    public static void main(String[] args) {
        new CF907A_MashaAndBears().run();
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
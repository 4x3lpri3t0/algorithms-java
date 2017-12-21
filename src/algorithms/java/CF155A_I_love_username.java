import java.io.*;
import java.util.*;

public class CF155A_I_love_username {
    private void solve() {
        int n = readInt();
        int max = readInt();
        int min = max;
        int ret = 0;
        for (int i = 1; i < n; i++) {
            int cur = readInt();
            if (cur > max) {
                ret++;
                max = cur;
            } else if (cur < min) {
                ret++;
                min = cur;
            }
        }

        out.println(ret);
    }

    public static void main(String[] args) {
        new CF155A_I_love_username().run();
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
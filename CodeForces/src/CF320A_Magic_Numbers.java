import java.io.*;
import java.util.*;

public class CF320A_Magic_Numbers {
    private void solve() {
        String n = readString();

        for (int i = 0; i < n.length(); i++) {
            char cur = n.charAt(i);

            if (cur == '1') {
                continue;
            }

            if (cur == '4') {
                if (i > 0 && n.charAt(i - 1) == '1') {
                    continue;
                }

                if (i > 1 && n.charAt(i - 1) == '4' && n.charAt(i - 2) == '1') {
                    continue;
                }
            }

            out.println("NO");
            return;
        }

        out.println("YES");
    }

    public static void main() {
        new CF320A_Magic_Numbers().run();
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
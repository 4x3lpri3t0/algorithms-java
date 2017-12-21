import java.io.*;
import java.util.*;

/*
    With a little try and guess, you can find out that the zero string
    (00...0) can't be converted to anything else
    and nothing else can be converted to zero.

    All other conversions are possible.
*/

public class CF282C_XORandOR {
    private void solve() {
        String a = readString();
        String b = readString();
        String ret = "NO";

        if (a.equals(b)) {
            ret = "YES";
        } else if (a.length() != b.length()) {
            ret = "NO";
        } else if (a.contains("1") && b.contains("1")) {
            ret = "YES";
        }

        out.println(ret);
    }

    public static void main(String[] args) {
        new CF282C_XORandOR().run();
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
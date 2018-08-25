import java.io.*;
import java.util.StringTokenizer;

public class CF1029A_ManyEqualSubstrings {
    private void solve() {
        int length = readInt();
        int count = readInt();
        String pattern = readString();

        int i = length - 1;
        while (i > 0 && !pattern.endsWith(pattern.substring(0, i))) {
            i--;
        }

        out.print(pattern);
        for (int k = 1; k < count; k++) {
            out.print(pattern.substring(i));
        }
    }

    public static void main(String[] args) {
        new CF1029A_ManyEqualSubstrings().run();
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

    int[] readIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = readInt();
        }
        return a;
    }
}
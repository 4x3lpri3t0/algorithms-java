import java.io.*;
import java.util.StringTokenizer;

public class CF279B_Books_alt2 {
    private void solve() {
        int n = readInt(), t = readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = readInt();

        int sum = 0, max = 0;
        for (int i = 0, j = 0; i < n; i++) {
            sum += a[i];
            while (j < n && sum > t)
                sum -= a[j++];
            max = Math.max(max, i - j + 1);
        }

        out.println(max);
    }

    public static void main(String[] args) {
        new CF279B_Books_alt2().run();
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
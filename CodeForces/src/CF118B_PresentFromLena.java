import java.io.*;
import java.util.*;

public class CF118B_PresentFromLena {
    private void solve() {
        int N = readInt();
        String [] s = new String[N + 1];

        for (int i = 0; i <= N; i++) {
            s[i] = "" + i;
            for(int j = i - 1; j >= 0; j--) {
                s[i] = j + " " + s[i] + " " + j;
            }
            for(int j = 0; j < N - i; j++) {
                s[i] = "  " + s[i];
            }
            out.println(s[i]);
        }
        for(int i = N - 1; i >= 0; i--) {
            out.println(s[i]);
        }
    }

    public static void main(String[] args) {
        new CF118B_PresentFromLena().run();
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
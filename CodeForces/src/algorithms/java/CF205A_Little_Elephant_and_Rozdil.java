import java.io.*;
import java.util.*;

public class CF205A_Little_Elephant_and_Rozdil {
    private void solve() {
        int n = readInt();
        boolean multipleMin = false;
        int min = Integer.MAX_VALUE;
        int minIdx = 1;

        for (int i = 0; i < n; i++) {
            int cur = readInt();

            if (cur < min) {
                min = cur;
                minIdx = i + 1;
                multipleMin = false;
            } else if (cur == min) {
                multipleMin = true;
            }
        }

        out.println(multipleMin ? "Still Rozdil" : minIdx);
    }

    public static void main(String[] args) {
        new CF205A_Little_Elephant_and_Rozdil().run();
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
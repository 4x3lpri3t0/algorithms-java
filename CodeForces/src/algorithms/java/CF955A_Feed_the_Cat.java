import java.io.*;
import java.util.*;

public class CF955A_Feed_the_Cat {
    private void solve() {
        int hour = readInt();
        int mins = readInt();
        int H = readInt();
        int D = readInt();
        int C = readInt();
        int N = readInt();

        double discounted = 0;
        double nonDiscounted = Integer.MAX_VALUE;

        if (hour < 20) {
            // Get minutes left to 20:00
            int hLeft = 20 - hour - 1;
            int mLeft = (hLeft * 60) + (60 - mins);

            int neededBunsAtStart = (int)Math.ceil(H / (double)N);

            // Get non-discounted
            nonDiscounted = (double)(neededBunsAtStart * C);

            // Get discounted
            int accumulatedH = H + mLeft * D;
            int neededBunsAtDiscTime = accumulatedH / N;
            discounted = (neededBunsAtDiscTime * C) * 0.8;
        } else {
            // Buy at discount time anyways
            discounted = (((int)Math.ceil(H / (double)N)) * C) * 0.8;
        }

        // Print the min
        out.printf("%.4f", Math.min(discounted, nonDiscounted));
    }

    public static void main(String[] args) {
        new CF955A_Feed_the_Cat().run();
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
import java.io.*;
import java.util.*;

public class CF899A_SplittingInTeams {
    void solve() throws Exception {
        long n = readLong();
        String ans = "";
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < n; i++) {
            if (readInt() == 1)
                ones++;
            else
                twos++;
        }
        int twosWithoutOnes = Math.max(0, twos - ones);
        int twosWithOnes = twos - twosWithoutOnes;
        ones = ones - twosWithOnes;

        out.println(twosWithOnes + ones / 3);
    }

    public static void main(String[] args) throws Exception {
        new CF899A_SplittingInTeams().run();
    }

    public void run() {
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

    void init() throws IOException {
        String filename = "";
        if (filename.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        }
    }

    String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }

        return tok.nextToken();
    }

    int readInt() {
        return Integer.parseInt(readString());
    }

    long readLong() {
        return Long.parseLong(readString());
    }

    double readDouble() {
        return Double.parseDouble(readString());
    }
}
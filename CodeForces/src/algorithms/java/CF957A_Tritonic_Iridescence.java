import java.io.*;
import java.util.*;

public class CF957A_Tritonic_Iridescence {
    private void solve() {
        int n = readInt();
        char[] A = readString().toCharArray();

        // Canvas already invalid
        char prev = ' ';
        char post = ' ';
        int qCount = 0;
        boolean consecutiveQs = false;
        boolean consecutiveSame = false;
        for (int i = 0; i < A.length; i++) {
            char cur = A[i];
            boolean notFirst = i > 0;
            boolean notLast = i < A.length - 1;

            if (cur != '?') {
                if (notFirst && cur == A[i - 1]) {
                        out.println("No");
                        return;
                }

                if (notLast && cur == A[i + 1]) {
                        out.println("No");
                        return;
                }
            } else { // '?' case
                qCount++;

                // '??' case
                if ((notFirst && A[i - 1] == cur) || (notLast && cur == A[i + 1])) {
                    consecutiveQs = true;
                }

                if (notFirst && notLast && A[i - 1] == A[i + 1]) {
                    consecutiveSame = true; // 'C?C'
                }
            }
        }

        if (qCount == 0) {
            out.println("No");
            return;
        }

        if (qCount == A.length // All '?'
                || consecutiveQs // one '??'
                || consecutiveSame // 'C?C'
                || A[0] == '?' // '?CMY'
                || A[A.length - 1] == '?' // 'CMY?'
                || qCount  == 1 && A.length == 2) { // 'Y?'
            out.println("Yes");
            return;
        }

        out.println("No"); // C?M, C?MC?M
    }

    public static void main(String[] args) {
        new CF957A_Tritonic_Iridescence().run();
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
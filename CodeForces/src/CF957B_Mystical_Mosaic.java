import java.io.*;
import java.util.*;

// http://codeforces.com/contest/957/problem/B

public class CF957B_Mystical_Mosaic {
    // Both rows have ones in the same position?
    private boolean haveOneAtSameC(int R1[], int R2[], int C) {
        for (int i = 0; i < C; i++) {
            if (R1[i] == 1 && R2[i] == 1) {
                return true;
            }
        }

        return false;
    }

    private boolean areEqual(int R1[], int R2[], int C) {
        for (int i = 0; i < C; i++) {
            if (R1[i] != R2[i]) {
                return false;
            }
        }

        return true;
    }

    private void solve() {
        int R = readInt();
        int C = readInt();
        int A[][] = new int[R][C];

        // Put 1s in the # positions for (i, j)
        for (int i = 0; i < R; i++) {
            String s = readString();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '#') {
                    A[i][j]++;
                }
            }
        }

        // Iterate rows
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                // If one of them has a 1, they need to be equal
                if (haveOneAtSameC(A[i], A[j], C) && !areEqual(A[i], A[j], C)) {
                    out.print("No");

                    return;
                }
            }
        }

        out.print("Yes");
    }

    public static void main(String[] args) {
        new CF957B_Mystical_Mosaic().run();
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
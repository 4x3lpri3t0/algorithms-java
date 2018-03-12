import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CF948A_Protect_Sheep {
    private void solve() {
        int R = readInt();
        int C = readInt();
        char[][] matrix = getInput(R, C);

        // Solution
        if (R == 1 && C == 1 && matrix[0][0] == 'W') {
            out.println("no");
            return;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char curr = matrix[j][i];
                if (curr == 'S') {
                    // Check borders...
                    if ((i > 0 && matrix[j][i-1] == 'W') ||
                        (i < R - 1 && matrix[j][i+1] == 'W') ||
                        (j > 0 && matrix[j-1][i] == 'W') ||
                        (j < C - 1 && matrix[j+1][i] == 'W')) {
                        out.println("no");
                        return;
                    }
                }
            }
        }

        out.println("yes");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char curr = matrix[j][i];
                out.print(curr);
            }
            out.println();
        }
    }

    private char[][] getInput(int r, int c) {
        char[][] matrix = new char[c][r];

        for (int i = 0; i < r; i++) {
            String line = readString();
            for (int j = 0; j < c; j++) {
                char character = line.charAt(j);
                if (character == '.')
                    matrix[j][i] = 'D';
                else
                    matrix[j][i] = character;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        new CF948A_Protect_Sheep().run();
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
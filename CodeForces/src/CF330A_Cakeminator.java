import java.io.*;
import java.util.*;

public class CF330A_Cakeminator {
    private void solve() {
        int r = readInt();
        int c = readInt();
        boolean[] rows = new boolean[r];
        boolean[] cols = new boolean[c];
        Arrays.fill(rows, true);
        Arrays.fill(cols, true);

        for (int i = 0; i < r; i++) {
            char[] curStr = readString().toCharArray();;

            for (int j = 0; j < c; j++) {
                char cur = curStr[j];
                if (cur == 'S') {
                    rows[i] = false;
                    cols[j] = false;
                }
            }
        }

        int edibleRows = 0;
        for (int i = 0; i < r; i++) {
            if(rows[i])
                edibleRows++;
        }
        int edibleCols = 0;
        for (int j = 0; j < c; j++) {
            if(cols[j])
                edibleCols++;
        }
        out.println(edibleCols * r + edibleRows * c - edibleCols * edibleRows);
    }

    public static void main(String[] args) {
        new CF330A_Cakeminator().run();
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
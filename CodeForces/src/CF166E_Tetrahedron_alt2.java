import java.io.*;
import java.util.*;

public class CF166E_Tetrahedron_alt2 {
    private void solve() {
        int n = readInt();
        long total = n % 2 == 0 ? 3 : 6;
        long factor = n % 2 == 0 ? 2 : 6;
        if(n == 0 || n == 1)
            out.print(0);
        else
        {
            n /= 2;
            n--;
            for (int i = 0; i != n; i++)
            {
                factor *= 9;
                factor %= 1000000007;
                total += factor;
                total %= 1000000007;
            }

            out.print(total);
        }
    }

    public static void main(String[] args) {
        new CF166E_Tetrahedron_alt2().run();
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
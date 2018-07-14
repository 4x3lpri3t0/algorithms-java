import java.io.*;
import java.util.*;

public class CF69A_YoungPhysicist {
    private void solve() {
        int n = readInt();
        int x = 0;
        int y = 0;
        int z = 0;
        String result = "YES";

        for (int i = 0; i < n; i++) {
            x += readInt();
            y += readInt();
            z += readInt();
        }

        if (x != 0 || y != 0 || z != 0)
            result = "NO";

        out.println(result);
    }

    public static void main(String[] args) {
        new CF69A_YoungPhysicist().run();
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
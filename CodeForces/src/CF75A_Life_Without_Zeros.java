import java.io.*;
import java.util.*;

public class CF75A_Life_Without_Zeros {
    private void solve() {
        int a = readInt();
        int b = readInt();
        long sum = a + b;

        String aAfter = Integer.toString(a);
        String bAfter = Integer.toString(b);
        aAfter = aAfter.replaceAll("0", "");
        bAfter = bAfter.replaceAll("0", "");
        int aAfterInt = Integer.parseInt(aAfter);
        int bAfterInt = Integer.parseInt(bAfter);
        long sumAfter = aAfterInt + bAfterInt;

        String expected = Long.toString(sum).replaceAll("0", "");

        out.println(Long.toString(sumAfter).equals(expected) ? "YES" : "NO");
    }

    public static void main(String[] args) {
        new CF75A_Life_Without_Zeros().run();
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
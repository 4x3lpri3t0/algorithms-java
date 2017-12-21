import java.io.*;
import java.util.*;

public class CF899C_DividingTheNumbers {
    private void solve() {
        int n = readInt();
        long sum = n * (n + 1) / 2;

        long half = sum / 2;
        List<Integer> result = new ArrayList<>();
        for(int i = n; i >= 1; i--){
            if (half >= i) {
                half -= i;
                result.add(i);
            }
        }

        out.println(sum % 2);
        out.print(result.size());
        for (int v : result) {
            out.print(" " + v);
        }
        out.println();
    }

    public static void main(String[] args) {
        new CF899C_DividingTheNumbers().run();
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
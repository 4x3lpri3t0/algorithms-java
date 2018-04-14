import java.io.*;
import java.util.*;

public class CF300A_Array {
    public static void print(List<Integer> A) {
        System.out.print(A.size());
        for (int i = 0; i < A.size(); i++)
            System.out.print(" " + A.get(i));
        System.out.println();
    }

    private void solve() {
        int n = readInt();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> zero = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int x = readInt();
            if (x < 0)
                neg.add(x);
            else if (x > 0)
                pos.add(x);
            else // 0
                zero.add(x);
        }

        // Add two negs to pos
        if (pos.size() == 0) {
            int lastNegIdx = neg.size() - 1;
            int lastNeg = neg.get(lastNegIdx);
            pos.add(lastNeg);
            neg.remove(lastNegIdx);

            lastNeg = neg.get(lastNegIdx - 1);
            pos.add(lastNeg);
            neg.remove(lastNegIdx - 1);
        }

        // Add odd neg to zeros
        if (neg.size() % 2 == 0) {
            int lastNegIdx = neg.size() - 1;
            int lastNeg = neg.get(lastNegIdx);
            zero.add(lastNeg);
            neg.remove(lastNegIdx);
        }

        print(neg);
        print(pos);
        print(zero);
    }

    public static void main(String[] args) {
        new CF300A_Array().run();
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
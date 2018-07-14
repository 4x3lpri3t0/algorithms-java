import java.io.*;
import java.util.*;

public class CF230A_Dragons {
    class Item implements Comparable<Item> {
        int x, y;

        public Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Item o) {
            return x - o.x;
        }
    }

    private void solve() {
        int s = readInt();
        int n = readInt();
        Item[] a = new Item[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Item(readInt(), readInt());
        }
        Arrays.sort(a);
        for (Item item : a) {
            if (s <= item.x) {
                out.println("NO");
                return;
            }
            s += item.y;
        }
        out.println("YES");
    }

    public static void main(String[] args) {
        new CF230A_Dragons().run();
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
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF1027C_MinimumValueRectangle {
    private void solve() throws IOException {
        int n = readInt();

        while (n-- > 0) {
            int stickN = readInt();
            HashMap<Integer, Integer> map = new HashMap<>();

            int[] A =readIntArray(stickN);
            for (int i = 0; i < stickN; i++) {
                int cur = A[i];
                // Construct dict frequencies
                map.putIfAbsent(cur, 0);
                map.put(cur, map.get(cur) + 1);
            }

            // Iterate with logic to select candidates
            int i = 1;
            int first = -1;
            while (true) {
                if (map.containsKey(i)) {
                    int freq = map.get(i);
                    if (freq >= 4) {
                        out.println(i + " " + i + " " + i + " " + i);
                    } else if (freq >= 2) {
                        if (first == -1) {
                            first = i;
                        } else { // We had 1st candidate
                            out.println(first + " " + first + " " + i + " " + i);

                            break;
                        }
                    }
                }

                i++;
            }
        }
    }

    public static void main(String[] args) {
        new CF1027C_MinimumValueRectangle().run();
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

    int[] readIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = readInt();
        }
        return a;
    }
}
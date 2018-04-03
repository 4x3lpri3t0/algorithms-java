import java.io.*;
import java.util.*;

public class CF959B_Mahmoud_and_Ehab_and_the_message {
    private void solve() {
        HashMap<String, Integer> wordIdx = new HashMap<String, Integer>();
        int n = readInt();
        int k = readInt();
        int m = readInt();

        for (int i = 0; i < n; i++) {
            wordIdx.put(readString(), i);
        }
        int[] costs = new int[n];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = readInt();
        }

        for (int i = 0; i < k; i++) {
            int x = readInt();
            int min = Integer.MAX_VALUE;
            int[] groupIdxs = new int[x];

            for (int j = 0; j < x; j++) {
                int z = readInt() - 1; // Base 0
                groupIdxs[j] = z;
                min = Math.min(costs[z], min);
            }

            // Apply min for each of the group
            for (int j = 0; j < x; j++) {
                int idx = groupIdxs[j];
                costs[idx] = min;
            }
        }

        long totalCost = 0;
        for (int i = 0; i < m; i++) {
            // Get idx (map)
            String str = readString();
            int idx = wordIdx.get(str);

            // Get cost (array)
            totalCost += costs[idx];
        }

        out.println(totalCost);
    }

    public static void main(String[] args) {
        new CF959B_Mahmoud_and_Ehab_and_the_message().run();
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
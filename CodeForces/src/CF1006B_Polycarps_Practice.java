import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF1006B_Polycarps_Practice extends PrintWriter {
    public void solve() throws IOException {
        int n = readInt();
        int k = readInt();
        Integer[] A = readIntArray(n);
        Integer[] B = A.clone();

        // Sort
        Arrays.sort(B, Collections.reverseOrder());

        Vector<Integer> maxs = new Vector<>();
        // Put n max items into vector
        for (int i = 0; i < k; i++) {
            int cur = B[i];
            maxs.add(cur);
        }

        int[] distributions = new int[k];
        int currentDistr = 0;
        long sum = 0;
        // Iterate again, store in an array the lengths
        for (int i = 0; i < n; i++) {
            distributions[currentDistr]++;

            int cur = A[i];

            if (maxs.contains(cur)) {
                // Remove it from vector
                maxs.remove((Object)cur);

                sum += cur;

                // Next distr
                if (maxs.size() > 0)
                    currentDistr++;
            }
        }

        println(sum);
        for (int distribution : distributions) {
            print(distribution + " ");
        }
    }

    BufferedReader in;
    StringTokenizer stok;

    public void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(abs(-1));
        }
    }

    CF1006B_Polycarps_Practice() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF1006B_Polycarps_Practice(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF1006B_Polycarps_Practice().run();
    }

    String read() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(read());
    }

    long readLong() throws IOException {
        return Long.parseLong(read());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(read());
    }

    Integer[] readIntArray(int len) throws IOException {
        Integer[] a = new Integer[len];
        for (int i = 0; i < len; i++) {
            a[i] = readInt();
        }
        return a;
    }

    <T> List<T>[] createAdjacencyList(int countVertex) {
        List<T>[] res = new List[countVertex];
        for (int i = 0; i < countVertex; i++) {
            res[i] = new ArrayList<T>();
        }
        return res;
    }
}
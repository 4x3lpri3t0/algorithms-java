import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF437A_TheChildAndHomework extends PrintWriter {
    class comp implements Comparator<String> {
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

    public void solve() throws IOException {
        String[] A = new String[4];

        for (int i = 0; i < 4; i++) {
            A[i] = read();
        }

        Arrays.sort(A, new comp());

        if ((A[0].length() - 2) * 2 <= A[1].length() - 2 && A[3].length() - 2 >= (A[2].length() - 2) * 2)
            println("C");
        else if ((A[0].length() - 2) * 2 <= A[1].length() - 2)
            println(A[0].charAt(0));
        else if (A[3].length() - 2 >= (A[2].length() - 2) * 2)
            println(A[3].charAt(0));
        else
            println("C");
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

    CF437A_TheChildAndHomework() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF437A_TheChildAndHomework().run();
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

    int[] readIntArray(int len) throws IOException {
        int[] a = new int[len];
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
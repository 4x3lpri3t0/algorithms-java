import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF106A_CardGame extends PrintWriter {
    public void solve() throws IOException {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
            put('T', 10);
            put('J', 11);
            put('Q', 12);
            put('K', 13);
            put('A', 14);
        }};

        char trump = read().charAt(0);
        String p1 = read();
        String p2 = read();
        char r1 = p1.charAt(0);
        char s1 = p1.charAt(1);
        char r2 = p2.charAt(0);
        char s2 = p2.charAt(1);

        if (s1 == s2) {
            println(map.get(r1) > map.get(r2) ? "YES" : "NO");
        } else if (s1 == trump) {
            println("YES");
        } else {
            println("NO");
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

    CF106A_CardGame() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF106A_CardGame().run();
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
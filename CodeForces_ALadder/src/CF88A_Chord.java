import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/problemset/problem/88/A
public class CF88A_Chord extends PrintWriter {
    String noteString = "C, C#, D, D#, E, F, F#, G, G#, A, B, H";
    final String[] notes = noteString.split(", ");

    private int dist(String from, String to) {
        int i = 0;
        while (!notes[i].equals(from)) {
            i++;
        }

        int dist = 0;
        while (!notes[(i + dist) % notes.length].equals(to)) {
            dist++;
        }

        return dist;
    }

    public void solve() throws IOException {
        String[] input = in.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            int d1 = dist(input[i], input[(i + 1) % 3]);
            int d2 = dist(input[i], input[(i + 2) % 3]);
            if (max(d1, d2) == 7) {
                if (min(d1, d2) == 3) {
                    println("minor");
                    return;
                }
                if (min(d1, d2) == 4) {
                    println("major");
                    return;
                }
            }
        }
        println("strange");
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

    CF88A_Chord() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF88A_Chord().run();
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
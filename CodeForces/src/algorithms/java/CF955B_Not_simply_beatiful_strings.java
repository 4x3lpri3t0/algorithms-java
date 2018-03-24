import java.io.*;
import java.util.*;

public class CF955B_Not_simply_beatiful_strings {
    private void solve() {
        char[] arr = readString().toCharArray();
        int[] fr = new int[26];
        int sym = 0;

        // Store frequency
        for (int i = 0; i < arr.length; i++) {
            fr[arr[i] - 'a']++;
            if (fr[arr[i] - 'a'] == 1) {
                sym++;
            }
        }

        // Not enough or too many symbols
        if (sym > 4 || sym <= 1) {
            out.println("No");

            return;
        }

        if (sym == 3) {
            // abc cannot have two adorable substrings (abbc could; ab - bc)
            if (arr.length == 3) {
                out.println("No");
            } else {
                // zzcxx (zc - zxx), or zcxx (zx - cx)
                out.println("Yes");
            }

            return;
        }

        if (sym == 2) {
            for (int i = 0; i < 26; i++) {
                if (fr[i] == 1) {
                    out.println("No");

                    // Smaller set has only one occurrence
                    // -> Not enough for forming two adorable substrings
                    return;
                }
            }
        }

        out.println("Yes");
    }

    public static void main(String[] args) {
        new CF955B_Not_simply_beatiful_strings().run();
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
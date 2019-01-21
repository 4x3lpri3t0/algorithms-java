import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.lang.System.*;

class UVA272_TEXQuotes {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(in);

        int count = 0;
        while (sc.ready()) {
            String line = sc.nextLine();

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '"') {
                    if (count % 2 == 0) {
                        line = line.substring(0, i) + "``" + line.substring(i + 1);
                    } else {
                        line = line.substring(0, i) + "''" + line.substring(i + 1);
                    }

                    count++;
                }
            }

            out.println(line);
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}
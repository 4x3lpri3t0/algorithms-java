import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.lang.System.*;

class UVA11172_RelationalOperator {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(in);
        PrintWriter out = new PrintWriter(System.out);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (l > r) {
                out.println(">");
            } else if (l < r) {
                out.println("<");
            } else {
                out.println("=");
            }
        }

        out.flush();
        out.close();
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
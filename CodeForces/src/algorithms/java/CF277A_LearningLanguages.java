import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class CF277A_LearningLanguages extends PrintWriter {
    static boolean[][] adjMat;
    static boolean[] visited;
    static int N, M;

    static void dfs(int u) {
        visited[u] = true;
        for (int i = 0; i < N + M; i++) {
            if (!visited[i] && adjMat[u][i]) {
                dfs(i);
            }
        }
    }

    public void solve() throws IOException {
        N = nextInt(); // Employees
        M = nextInt(); // Languages
        adjMat = new boolean[N + M][N + M];

        int langCount = 0;
        for (int i = 0; i < N; i++) {
            int k = nextInt();
            langCount += k;
            while (k-- > 0) {
                int x = nextInt() - 1 + N;
                adjMat[i][x] = adjMat[x][i] = true;
            }
        }

        if (langCount == 0) {
            println(N);
        } else {
            int count = -1;
            visited = new boolean[N + M];
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    count++;
                    dfs(i);
                }
            }

            println(count);
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

    CF277A_LearningLanguages() throws IOException {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    CF277A_LearningLanguages(String s) throws IOException {
        super("".equals(s) ? "output.txt" : (s + ".out"));
        in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : (s + ".in")));
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF277A_LearningLanguages().run();
    }

    String next() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int[] nextIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = nextInt();
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
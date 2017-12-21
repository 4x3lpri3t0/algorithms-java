import java.io.*;
import java.util.*;

public class CF166E_Tetrahedron_alt1 {
    private void solve() {
        Scanner sc=new Scanner(System.in);
        long n,zD=1,zABC=0,nzD,nzABC,m= 1000000007;
        int i;
        n=sc.nextInt();
        for (i=1;i<=n;i++)
        {
            nzD=(zABC*3)%m;
            nzABC=(zABC*2+zD)%m;
            zD=nzD;
            zABC=nzABC;
        }
        System.out.print(zD);
    }

    public static void main(String[] args) {
        new CF166E_Tetrahedron_alt1().run();
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
import java.util.HashMap;
import java.util.Scanner;

public class COINS {
    private HashMap<Integer, Long> map = new HashMap<>();

    private long getN(int n) {
        if (n < 12)
            return n;

        if (!map.containsKey(n)) {
            map.put(n, getN(n / 2) + getN(n / 3) + getN(n / 4));
        }

        return map.get(n);
    }

    void solve() {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()){
            int n = sin.nextInt();
            System.out.println(getN(n));
        }
    }

    public static void main(String[] args) {
        new COINS().solve();
    }
}
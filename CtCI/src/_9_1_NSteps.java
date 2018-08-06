import static java.lang.System.out;

public class _9_1_NSteps {
    public static int countWays_TopDown(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWays_TopDown(n - 1, map) +
                    countWays_TopDown(n - 2, map) +
                    countWays_TopDown(n - 3, map);

            return map[n];
        }
    }

    private static long countWays_BottomUp(int n, int[] map) {
        map[0] = 1;
        map[1] = 1; // when n = 1, answer is 1
        map[2] = 2; // when n = 2, answer is 2, (1+1) and (2)
        map[3] = 4; // (1+1+1), (1+2), (2+1), (3)

        for (int i = 4; i <= n; i++) {
            map[i] = map[i - 1] + map[i - 2] + map[i - 3];
        }

        return map[n];
    }

    public static void main(String[] args) {

        int[] map = new int[100];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        out.println(countWays_TopDown(0, map)); // 1
        out.println(countWays_TopDown(1, map)); // 1
        out.println(countWays_TopDown(10, map)); // 274
        out.println(countWays_TopDown(36, map)); // 2082876103

        out.println(countWays_BottomUp(0, map));
        out.println(countWays_BottomUp(1, map));
        out.println(countWays_BottomUp(10, map));
        out.println(countWays_BottomUp(36, map));
    }
}

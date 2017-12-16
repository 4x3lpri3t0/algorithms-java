import java.util.Scanner;

public class CF898B_ProperNutrition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        // All of them: (1 ≤ n ≤ 10 000 000)

        // Find out if it's possible to buy some amount of A and B and spend exactly N.
        // x·a + y·b = n or tell that it's impossible ("NO").

        // FIRST: Solve for x
        // x·a  = n- y·b
        // x = (n- y·b)/a

        int x = 0;
        int y = 0;
        String doable = "NO";
        for (; y * b <= n; y++) {
            x = (n - y * b) / a;

            if (x * a + y * b == n) {
                doable = "YES";
                break;
            }
        }

        // Try iterating over x
        if (doable == "NO") {
            x = 0;
            y = 0;
            for (; x * a <= n; x++) {
                y = (n - x * a) / b;

                if (x * a + y * b == n) {
                    doable = "YES";
                    break;
                }
            }
        }

        System.out.println(doable);
        if (doable == "YES") {
            System.out.println(x + " " + y);
        }
    }
}
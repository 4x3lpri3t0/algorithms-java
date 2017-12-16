import java.util.Scanner;

public class CF898A_Rounding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        long rest = n % 10;
        long result = n / 10;

        if (rest > 5)
            result += 1;

        System.out.println(result * 10);
    }
}
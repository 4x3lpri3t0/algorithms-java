import java.util.Scanner;

public class CF4A_Watermelon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int w = in.nextInt();

        // TODO: Wrong answer on test 5 (???)

        System.out.println(w % 2 == 0 ? "YES" : "NO");
    }
}
import static java.lang.System.*;

public class Ex_1_1_06 {

    public static void main() {
        int f = 0;
        int g = 1;

        for (int i = 0; i <= 15; i++) {
            out.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
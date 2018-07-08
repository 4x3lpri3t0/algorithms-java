/**
 * Created by Axel on 2017-04-04.
 */
public class Ex_1_1_09 {
    public static void main()
    {
        int N = 234245;

        // Java built-in method
        StdOut.println(Integer.toBinaryString(N));

        // Implementation
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        StdOut.println(s);
    }
}

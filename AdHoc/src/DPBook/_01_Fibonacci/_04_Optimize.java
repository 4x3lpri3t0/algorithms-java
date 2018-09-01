package DPBook._01_Fibonacci;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _04_Optimize {
    // Compute the nth fibonacci number iteratively
    // with constant space. We only need to save
    // the two most recently computed values
    static int fib(int n) {
        if (n < 2)
            return n;

        int n1 = 1, n2 = 0;
        for (int i = 2; i < n; i++) {
            int n0 = n1 + n2;
            n2 = n1;
            n1 = n0;
        }

        return n1 + n2;
    }

    public static void main(String[] args) {
        out.println(fib(0)); // 0
        out.println(fib(1)); // 1
        out.println(fib(5)); // 5
        out.println(fib(10)); // 55
    }
}

package DP;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/80003
public class NthFibonacci {
    public static int getNthFib(int n) {
        if (n == 0 || n == 1)
            return n;

        // fib(n) = f(n-1) + f(n-2)

        int n1 = 1; // (n-1)
        int n2 = 0; // (n-2)
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = n1 + n2;
            n2 = n1;
            n1 = res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(0)); // 0
        System.out.println(getNthFib(1)); // 1
        System.out.println(getNthFib(2)); // 1
        System.out.println(getNthFib(3)); // 2
        System.out.println(getNthFib(4)); // 3
        System.out.println(getNthFib(5)); // 5
        System.out.println(getNthFib(6)); // 8
        System.out.println(getNthFib(7)); // 13
    }
}

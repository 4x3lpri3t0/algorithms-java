class _70_Climbing_Stairs {
    // Dynamic Programming
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    //    Time complexity : O(n). Single loop upto n.
    //
    //    Space complexity : O(n). dp array of size n is used.

    // Fibonacci Formula
    public int climbStairs_fibo(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);

        return (int) (fibn / sqrt5);
    }
    //    Time complexity : O(log(n)). pow method takes log(n) time.
    //
    //    Space complexity : O(1). Constant space is used.
}

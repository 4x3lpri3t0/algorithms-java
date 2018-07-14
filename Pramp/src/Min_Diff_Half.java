import java.util.Arrays;

public class Min_Diff_Half {
    static boolean minDiffHalfDivide(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++)
            sum += A[i];

        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 1; i <= A.length; i++) {
            for (int j = sum; j >= A[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - A[i - 1]];
            }
        }
        int diff = 0;
        while (!dp[sum / 2 + diff]) {
            diff++;
        }
        return dp[sum / 2 + diff];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 12};

        if (minDiffHalfDivide(arr))
            System.out.println("can divide");
        else
            System.out.println("cannot divide");
    }

}
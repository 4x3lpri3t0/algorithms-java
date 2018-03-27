public class _566_Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;

        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int row = count / c;
                int col = count % c;
                res[row][col] = nums[i][j];
                count++;
            }
        }

        return res;
    }
}
//
//
// Time complexity : O(m∗n). We traverse the entire matrix of size m∗n once only.
//
// Space complexity : O(m∗n). The resultant matrix.
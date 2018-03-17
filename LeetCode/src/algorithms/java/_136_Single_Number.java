

// https://leetcode.com/problems/single-number

public class _136_Single_Number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}

// XOR is commutative
// so N1^N2^N3 = N1^N3^N2 = N2^N3^N1 = N2^N1^N3 = …
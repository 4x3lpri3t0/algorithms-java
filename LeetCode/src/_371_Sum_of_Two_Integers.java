// https://leetcode.com/problems/sum-of-two-integers

class _371_Sum_of_Two_Integers {
    // Iterative
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}

//// Recursive
//public int getSum(int a, int b) {
//    return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
//}

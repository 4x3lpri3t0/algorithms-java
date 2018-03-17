import java.io.*;
import java.util.*;

// https://leetcode.com/problems/self-dividing-numbers

public class _728_Self_Dividing_Numbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int n = left; n <= right; n++) {
            if (selfDividing(n)) {
                ans.add(n);
            }
        }

        return ans;
    }

    private boolean selfDividing(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            if (d == 0 || (n % d) != 0) {
                return false;
            }
        }

        return true;
    }
}
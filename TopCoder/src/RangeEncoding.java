// https://arena.topcoder.com/index.html#/u/practiceCode/16919/55785/14592/2/330166

public class RangeEncoding {
    public int minRanges(int[] arr) {
        if (arr.length == 1)
            return 1;

        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            if (cur - arr[i - 1] > 1)
                result++;
        }

        return result;
    }
}
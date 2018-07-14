// https://leetcode.com/problems/median-of-two-sorted-arrays
// TODO: Need to debug

public class _4_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int first = 0, second = 0;
        int median = (nums1.length + nums2.length) / 2;

        while ((i + j <= median) && (i < nums1.length || j < nums2.length)) {
            if (j >= nums2.length || i < nums1.length && nums1[i] <= nums2[j]) {
                first = second;
                second = nums1[i];
                i++;
            } else {
                first = second;
                second = nums2[j];
                j++;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return ((double) first + second) / 2;
        } else {
            return second;
        }
    }
}

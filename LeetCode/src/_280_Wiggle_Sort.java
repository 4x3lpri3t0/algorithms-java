public class _280_Wiggle_Sort {
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
     }

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean even = i % 2 == 0;
            boolean biggerThanNext = nums[i] > nums[i + 1];
            if (even == biggerThanNext) {
                swap(nums, i, i + 1);
            }
        }
    }
}
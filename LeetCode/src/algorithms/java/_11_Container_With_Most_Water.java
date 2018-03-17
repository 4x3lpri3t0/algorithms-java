// https://leetcode.com/problems/container-with-most-water

class _11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int newArea = Math.min(height[l], height[r]) * (r - l);
            maxarea = Math.max(maxarea, newArea);

            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return maxarea;
    }
}

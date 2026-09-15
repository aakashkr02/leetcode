class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Increasing → peak is on right
                left = mid + 1;
            } else {
                // Decreasing → peak is on left or mid
                right = mid;
            }
        }

        return left;
    }
}
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && mid < nums.length - 1 
                    && nums[mid] > nums[mid-1] 
                    && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if (mid > 0 && nums[mid] >= nums[mid-1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}

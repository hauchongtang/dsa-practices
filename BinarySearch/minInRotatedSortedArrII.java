class Solution {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums[low] < nums[high]) return nums[low];
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[low], nums[high]);

        while (low < high) {
            int mid = low + (high - low) / 2;
            // pivot
            if (nums[mid] < nums[mid-1]) return nums[mid];
            if (nums[mid] == nums[mid-1]) {
                boolean b = true;
                int m = mid;
                while (m < nums.length-1) {
                    m++;
                    if (nums[m] < nums[m-1]) return nums[m];
                }
            }
            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else high = mid;
        }
        return nums[low];
    }
}

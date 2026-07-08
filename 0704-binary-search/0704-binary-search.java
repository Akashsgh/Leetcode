class Solution {
    public int search(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;

        while (low <= hi) {
            int mid = low + (hi - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}

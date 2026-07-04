class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0, left = 0, right = 0, windowProduct = 1;
        
        while (right < nums.length) {
            if (left > right) {
                right++;
            } else if (nums[right] * windowProduct < k) {
                windowProduct *= nums[right];
                result += ++right - left;
            } else {
                windowProduct = Math.max(1, windowProduct / nums[left++]);
            }
        }

        return result;
    }
}
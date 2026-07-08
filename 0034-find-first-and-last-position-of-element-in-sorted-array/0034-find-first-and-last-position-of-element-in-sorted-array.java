class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = findPos(nums, target, true);
        int last = findPos(nums, target, false);

        return new int[]{first, last};
    }

    private int findPos(int[] nums, int target, boolean first) {

        int l = 0;
        int r = nums.length - 1;

        int pos = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {

                pos = mid;

                if (first)
                    r = mid - 1;
                else
                    l = mid + 1;

            } else if (target < nums[mid]) {

                r = mid - 1;

            } else {

                l = mid + 1;
            }
        }

        return pos;
    }
}
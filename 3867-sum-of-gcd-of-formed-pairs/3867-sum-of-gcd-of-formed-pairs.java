class Solution {
    public long gcdSum(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];

        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr = Math.max(curr, nums[i]);
            arr[i] = gcd(nums[i], curr);
        }

        Arrays.sort(arr);

        long ans = 0;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            ans += gcd(arr[l], arr[r]);
            l++;
            r--;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
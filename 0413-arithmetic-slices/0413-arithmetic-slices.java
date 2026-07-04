class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp=new int[nums.length];
        for(int i=2;i<nums.length;i++){
            if (nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
            }
        }
        int ans=0;
        for(int i=0;i<dp.length;i++){
            ans+=dp[i];
        }
        return ans;
    }
}
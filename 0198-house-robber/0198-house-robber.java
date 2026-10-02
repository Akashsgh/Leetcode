// class Solution {
//     static int[]dp;
//     public int rob(int[] nums) {
//         int n=nums.length;
//         dp=new int[n];   //0 to n-1
//         Arrays.fill(dp,-1); // mark
//         return loot(0,nums);
        
//     }
//     private int loot(int i,int[] nums){
//         if(i>=nums.length) return 0;
//         int pick=nums[i]+loot(i+2, nums);
//         int skip=loot(i+1,nums);
//         return dp[i]=Math.max(pick,skip);
//     }
// }

class Solution{
    public int rob(int[] nums){
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int rob=nums[i]+dp[i-2];

            int skip=dp[i-1];
            dp[i]=Math.max(rob, skip);
        }
        return dp[n-1];
    }
}
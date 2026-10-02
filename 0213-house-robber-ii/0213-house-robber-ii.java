class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int case1= robRange(nums,0, n-2); // don't rob last house

        int case2= robRange(nums,1, n-1); // don't rob first house
        return Math.max(case1, case2);
    }
    private int robRange(int[]nums, int start, int end){
        int prev1=0;
        int prev2=0;
        for(int i=start;i<=end;i++){
            int rob=nums[i]+prev2;
            int skip=prev1;
            int current=Math.max(rob, skip);


            prev2=prev1;
            prev1=current;

        }
        return prev1;
    }

}

  
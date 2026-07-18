class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        int ans=1;
        for(int i=2; i<=min; i++){
            if(min%i==0 && max%i==0) ans=i;
        }
        return ans;
        
    }
}
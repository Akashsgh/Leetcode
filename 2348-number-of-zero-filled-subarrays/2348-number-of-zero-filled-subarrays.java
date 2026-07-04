class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0;
        int z = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                z++;
                cnt += z;
            }else{
                z=0;
            } 
        }
        return cnt;
    }
}
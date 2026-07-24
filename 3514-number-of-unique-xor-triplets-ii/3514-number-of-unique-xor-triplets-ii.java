class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        int[]arr=nums.clone();
        Arrays.sort(arr);
        int max=arr[n-1];
        int T=1;
        while(T<=max){
            T<<=1;
        }
        boolean[]s1=new boolean[T];
        Arrays.fill(s1,false);
        boolean[]s2=new boolean[T];
        Arrays.fill(s2,false);
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                s1[nums[i]^nums[j]]=true;
            }
        }
        for(int i=0; i<T; i++){
            if(s1[i]==true){
                for(int num:nums){
                s2[i^num]=true;
            }
            }
        }
        int count=0;
        for(boolean flag:s2){
            if(flag==true){
                count++;
            }
        }
        return count;
    }
}
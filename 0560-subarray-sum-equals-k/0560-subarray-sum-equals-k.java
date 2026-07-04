class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length ;
        HashMap<Integer, Integer> map = new HashMap<>() ; 
        

        map.put(0, 1) ; 

        int[] arr = new int[n] ;
        int prefix = 0 ;
        for(int i = 0 ; i < n ; i++){
            prefix += nums[i] ;
            arr[i] = prefix ;
        }
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            
            if (map.containsKey(arr[i] - k)) count += map.get(arr[i] - k) ;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1) ;
            
        }
        return count ;
    }
}
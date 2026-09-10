class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i =0; i<nums.length; i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){       // no print krega yha pr brACUSE HE CHCK THE find  or not
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i],i);

        }
        return new int[]{};
    }
}
//         int n=nums.length;
//         for(int i=0; i<n;i++){
//             for(int j=i+1; j<n;j++){
//                 if(nums[i]+nums[j]==target){
//                     return new int[]{i,j};
//                 }
//             }
//         }
//         return new int[]{};
//     }
// }

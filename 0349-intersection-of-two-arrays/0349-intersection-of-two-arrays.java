
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

       HashSet<Integer> set = new HashSet<>();

       for(int i=0;i<n;i++) {
            set.add(nums1[i]);
        }
        List<Integer> helper = new ArrayList<>();

        for(int i = 0; i<m;i++) {
            if(set.contains(nums2[i])) {
                helper.add(nums2[i]);
                set.remove(nums2[i]); 
            }
        }

        int size = helper.size();
        int ans[] = new int[size];

        for(int i=0; i<size; i++) {
            ans[i] = helper.get(i);
        }

        return ans;
    }
}


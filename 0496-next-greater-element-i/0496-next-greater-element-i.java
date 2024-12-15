class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.put(nums2[i], -1);
            for(int j = i + 1; j < m; j++){
                if(nums2[i] < nums2[j]){
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
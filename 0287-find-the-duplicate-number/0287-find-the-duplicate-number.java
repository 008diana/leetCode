class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                ans = nums[i];
            }
            else{
                hm.put(nums[i], 1);
            }
        }
        return ans;
    }
}
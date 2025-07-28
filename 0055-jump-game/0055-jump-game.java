class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return true;
        }
        int curr = nums[0];
        if(curr == 0){
            return false;
        }
        int target = n - 1;
        int maxIndex = curr;
        for(int i = 1; i < n; i++){
            if(maxIndex >= target){
                return true;
            }
            int currIndex = i;
            if(currIndex <= maxIndex){
                maxIndex = Math.max(maxIndex, currIndex + nums[currIndex]);
            }
            // if(currIndex > maxIndex){
            //     return false;
            // }
        }
        return false;
    }
}
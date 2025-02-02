class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return true;
        } 
        // boolean result = false;
        // if(nums[0] % 2 == 0){
        //     result = true;
        // }
        for(int i = 0; i < n - 1; i++){
            if((nums[i] % 2 == 0 && nums[i+1] % 2 == 0) || (nums[i] % 2 != 0 && nums[i+1] % 2 != 0)){
                return false;
            }
        }
        return true;
    }
}
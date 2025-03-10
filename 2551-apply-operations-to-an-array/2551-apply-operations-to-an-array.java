class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i] * 2;
                nums[i+ 1] = 0;
            }
        }
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                result[counter] = nums[i];
                counter++;
            }
        }
        while(counter < n){
            result[counter] = 0;
            counter++;
        }
        return result;
    }
}
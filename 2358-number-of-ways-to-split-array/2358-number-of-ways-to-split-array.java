class Solution {
    public int waysToSplitArray(int[] nums) {
        int counter = 0;
        long sum = 0;
    
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        long left = 0;
        long right = sum;
        for(int i = 0; i < n - 1; i++){
            left += nums[i];
            right -= nums[i];
            if(left >= right){
                counter++;
            }
        }
        return counter;
    }
}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        if(nums.length == 3){
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int[] memo = new int[n+1];
        for(int i = 0; i < n + 1; i++){
            memo[i] = -1;
        }
        return maxMoney(nums, n - 1, memo);
    }

    public static int maxMoney (int[] nums, int index,int[] memo){
        if (index < 0) {
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }

        int left = nums[index] + maxMoney(nums, index - 2, memo);
        int right =  maxMoney(nums, index - 1, memo);       

        return memo[index] = Math.max(left, right);

    }
}
//undersatnding slowly slowly
class Solution {
    public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    
    for (int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
    }
    
    return dp[nums.length - 1];
    }
}
//my try
/*
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        if(n == 2) {
            Arrays.sort(nums);
            return nums[1];
        }
        int[] dp = new int [n];
        dp[0] = nums[0];
         dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], nums[i - 1]);// error here, had to be dp[i-1] instead of nums[i-1]
        } 
        return dp[n -1];
    }
    
}
*/
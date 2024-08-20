//getting there slowly
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int target = n + 1;
        int[] dp = new int [n + 1];
        dp[n] = 0;
        dp[n -1] = cost[n - 1];
        for(int i = n - 2 ; i >= 0; i--) {
            dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp [i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
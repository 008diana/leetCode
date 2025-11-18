class Solution {
    public int climbStairs(int n) {
        //return recursive(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1) ;
        //return memoization(n, dp);
        //return tabulation(n, dp);
        return spaceOptimized(n);
    }
    public static int recursive(int n){
        if(n == 0) return 1;
        if (n == 1) return 1;
        return recursive(n - 1) + recursive(n- 2);
    }
    public static int memoization(int n, int[] dp){
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
    }
    public static int tabulation(int n, int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int spaceOptimized(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        int prev2 = 1; 
        int prev = 1; 
        for(int i = 2; i <= n; i++){
            int cur_i = prev2 + prev;
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
}
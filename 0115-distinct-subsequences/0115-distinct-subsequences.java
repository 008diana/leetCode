class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] represents the number of distinct subsequences of s[0,i) that match t[0,j)
        int[][] dp = new int[m + 1][n + 1];
        
        // Empty string is a subsequence of any string once
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, we have two choices:
                // 1. Include the current character
                // 2. Exclude the current character
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, just copy the previous count
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
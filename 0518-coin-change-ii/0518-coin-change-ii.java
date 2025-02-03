class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length + 1][amount + 1];
        
        // Initialize first column
        for (int i = 0; i <= coins.length; i++) {
            memo[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // Don't use current coin
                memo[i][j] = memo[i-1][j];
                
                // Use current coin if possible
                if (j >= coins[i-1]) {
                    memo[i][j] += memo[i][j - coins[i-1]];
                }
            }
        }
        
        return memo[coins.length][amount];
    }
}
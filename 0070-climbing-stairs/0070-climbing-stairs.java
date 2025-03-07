class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    public static int countWays(int n, int[] memo){
        if(n == 0){
            return 1; 
        }
        if(n == 1){
            return 1;
        }
        
        if(memo[n] != -1){
            return memo[n];
        }
        return memo[n] = countWays(n - 2, memo) + countWays(n - 1, memo);
    }
}
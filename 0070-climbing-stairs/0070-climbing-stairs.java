class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(memo, n);
    }

    public static int countWays(int[] memo, int index){
        if(index == 1 || index == 0){
            return 1;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        return memo[index] = countWays(memo, index - 1) + countWays(memo, index - 2);
    }
}
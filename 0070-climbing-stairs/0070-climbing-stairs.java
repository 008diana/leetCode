//DP trial
class Solution {
    public int climbStairs(int n) {
        int[] ans = new int [45];
        ans[0] = 1;
        ans[1] = 2;
        for (int i = 2; i < 45; i++) {
            ans[i] = ans[i-1] + ans[i -2];
        }
        return ans[n - 1];
    }
}
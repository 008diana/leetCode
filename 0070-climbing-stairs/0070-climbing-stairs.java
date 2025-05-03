class Solution {
    public int climbStairs(int n) {
        int[] tabu = new int[n + 1];
        for(int i = 0; i <= n; i++){
            if(i == 0 || i == 1){
                tabu[i] = 1;
            }
            
            else{
                tabu[i] = tabu[i-1] + tabu[i-2];
            }
            
        }
        return tabu[n];
    }
}
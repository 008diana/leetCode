class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n * n; i++){
            map.put(i, 1);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int curr = grid[i][j];
                if(!map.containsKey(curr)){
                    ans[0] = curr;
                }
                map.remove(curr);
            }
        }
        ans[1] = map.keySet().iterator().next();
        return ans;
    }
}
class Solution {
    public long coloredCells(int n) {
        long result = 1;
        for(int i = 1; i < n; i++){
            result += (4 * i);
        }
        return result;
    }
}
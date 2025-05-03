class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int m = tops.length;
        int target1 = tops[0];
        int target2 = bottoms[0];

        int res1 = check(target1, tops, bottoms);
        if (res1 != -1) return res1;
        return check(target2, tops, bottoms); // try with target2 only if target1 fails
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int topswap = 0;
        int bottomswap = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; // impossible to make all values equal to target
            } else if (tops[i] != target) {
                topswap++; // need to swap to bring target to top
            } else if (bottoms[i] != target) {
                bottomswap++; // need to swap to bring target to bottom
            }
        }
        return Math.min(topswap, bottomswap);
    }
}

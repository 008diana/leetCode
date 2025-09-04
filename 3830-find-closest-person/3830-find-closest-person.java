class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(z - y);
        int d2 = Math.abs(z -x);
        if(d1 < d2){
            return 2;
        }
        else if ( d1 > d2){
            return 1;
        }
        return 0;
    }
}
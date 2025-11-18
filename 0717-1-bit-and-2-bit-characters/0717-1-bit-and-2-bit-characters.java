class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while(i < n){
            if(bits[i] == 1){
                i += 2;
                if(i >= n){
                    return false;
                }
            }
            else{
                i++;
            }
        }
        return true;
    }
}
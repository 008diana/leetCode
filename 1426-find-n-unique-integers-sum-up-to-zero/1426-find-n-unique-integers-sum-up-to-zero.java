class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if(n % 2 == 0){
            int k = n/2;
            for(int i = 1; i < k + 1; i++){
                result[i - 1] = -i;
                result[n - i] = i;
            }
            
        }
        else{
            int k = n/2;
            for(int i = 1; i < k + 1; i++){
                result[i - 1] = -i;
                result[n - i] = i;
            }
            result[n/2] = 0;
        }
        return result;
    }
}
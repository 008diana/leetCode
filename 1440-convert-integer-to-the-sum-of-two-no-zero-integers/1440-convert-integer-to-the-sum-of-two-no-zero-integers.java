class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        int a, b;
        for(int i = 1; i < n; i++){
            a = i;
            b = n - i;
            if(checkNonZero(a) && checkNonZero(b)){
                result[0] = a;
                result[1] = b;
                return result;
            }
        }
        return result;
    }
    public static boolean checkNonZero(int num){
        String str = String.valueOf(num);
        if(str.contains("0")){
            return false;
        }
        return true;
    }
}
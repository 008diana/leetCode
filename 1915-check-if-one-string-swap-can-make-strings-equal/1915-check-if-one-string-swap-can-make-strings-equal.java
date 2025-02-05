class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int m = s1.length();
        int n = s2.length();
        if(m != n){
            return false;
        }
        int[] different = new int[2];
        int j = 0;
        for(int i = 0; i < m; i++){
            char currChar1 = s1.charAt(i);
            char currChar2 = s2.charAt(i);
            if(currChar1 != currChar2){
                if(j == 2){
                    return false;
                }
               different[j] = i; 
               j++;
            }
        }
        if(s1.charAt(different[0]) == s2.charAt(different[1]) && s1.charAt(different[1]) == s2.charAt(different[0])){
            return true;
        }
        return false;
    }
}
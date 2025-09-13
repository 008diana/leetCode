class Solution {
    public int maxFreqSum(String s) {
        int maxVowFreq = 0;
        int maxConsFreq = 0;
        int n = s.length();
        int[] charArr = new int[26];
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            charArr[ch - 'a']++;
            if(isVowel(ch)){
                if(charArr[ch - 'a'] > maxVowFreq){
                    maxVowFreq = charArr[ch - 'a']; 
                }
            }
            else{
                if(charArr[ch - 'a'] > maxConsFreq){
                    maxConsFreq = charArr[ch - 'a']; 
                }
            }
        }
        return maxVowFreq + maxConsFreq;
    }

    public static boolean isVowel(char ch){
        String vowels = "aeiou";
        return vowels.contains(Character.toString(ch));
    }
}
//okay trying to learn what rolling hash is. attempt 1
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        
        int counter = 0; 

        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if(isPrefixAndSuffix(words[i], words[j])){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        int j = 0;
        if (str2.length() < str1.length()){
            return false;
        }
        else{
            for(int i = 0; i < str1.length(); i++){
                if(str2.charAt(j) != str2.charAt(str2.length() - str1.length() + j) || str2.charAt(j) != str1.charAt(i)){
                    return false;
                }
                j++;
            }
            return true;
        }
        //return true;
    }
}
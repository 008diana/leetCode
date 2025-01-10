class Solution {
    public int prefixCount(String[] words, String pref) {
        int m = words.length;
        int n = pref.length();
        int counter = 0;
        for(int i = 0; i < m ; i++){
            String word = words[i];
            if(word.length() >= n && word.substring(0, n).equals(pref)){
                counter++;
            }
        }
        return counter;
    }
}
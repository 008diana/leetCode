class Solution {
    public boolean doesAliceWin(String s) {
        boolean result;
        int n = s.length();
        int vowelCount = 0;
        String str = "";
        char last = 'a';
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                vowelCount++;
                str = str + "v";
                last = 'v';
            }
            else{
                if(last == 'v'){
                    str = str + "c";
                    last = 'c';
                }
                else{
                    last = 'c';
                }
            }
        }
        if(vowelCount == 0){
            return false;
        }
        if(vowelCount % 2 != 0){
            return true;
        }
        else{
            if(str.contains("vcv") || str.contains("vv")){
                return true;
            }
        }
        return false;
    }

    public static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ){
            return true;
        }
        return false;
    }
}
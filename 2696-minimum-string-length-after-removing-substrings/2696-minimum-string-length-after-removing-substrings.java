//time to grindd
class Solution {
    public int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")){
            if(s.contains("AB")){
                s = s.replaceAll("AB", "");
            }
            if(s.contains("CD")){
                s = s.replaceAll("CD", "");
            }
        }
        return s.length();
    }
}
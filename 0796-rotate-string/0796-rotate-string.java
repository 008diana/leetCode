class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i = 0; i < s.length(); i++){
            s = s.substring(1, s.length()) +  s.charAt(0);
            if(goal.equals(s)){
                return true;
            }
        }
        return false;
    }
}
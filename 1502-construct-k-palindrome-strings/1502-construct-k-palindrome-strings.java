class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(n == k){
            return true;
        }
        if(n < k){
            return false;
        }
        int counter = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                counter = counter + 2;
                set.remove(ch); 
            }
            else{
                    set.add(ch);
                }
        }
        if(set.size() <= k && counter + set.size() >= k){
            return true;
        }
        else{
            return false;
        }
    }
}
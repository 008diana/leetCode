class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        //int end = 0;

        int n = s.length();
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int end = 1;
        while(end < n && start < n){
            if(!set.contains(s.charAt(end))){
                max = Math.max(end - start + 1, max);
                set.add(s.charAt(end));
                end++;
            }
            else{
                max = Math.max(end - start, max);
                while(s.charAt(start) != s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(s.charAt(end));
                start++;
            }
        }
        return max;
    }
}
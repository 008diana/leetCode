class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int counter = 0;
        HashSet<String> res = new HashSet<>();
        HashSet<Character> left = new HashSet<>();
        left.add(s.charAt(0));
        HashMap<Character, Integer> right = new HashMap<>();

        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            if(right.containsKey(ch)){
                right.put(ch, right.get(ch) + 1);
            }
            else{
                right.put(ch, 1);
            }
        }

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 1; i < n - 1; i++){
            char ch = s.charAt(i);
            right.put(ch, right.get(ch) - 1);
            // if(right.get(ch) == 0){
            //     right.remove(ch);
            // }
            for(int j = 0; j < 26; j++){
                char check = alphabets.charAt(j);
                if(left.contains(check) && right.containsKey(check)){
                    if(right.get(check) != 0){
                        String palindrome = String.valueOf(new char[]{check, ch, check});
                        res.add(palindrome);
                    }
                }
            }
            left.add(ch);  
        }
        return res.size();
    }
}
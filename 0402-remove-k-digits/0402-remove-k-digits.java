class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();
        String ans = "";
        if (k >= n) {
            return "0";
        }
        
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            int curr = num.charAt(i) - '0';
                while(!stk.isEmpty() && stk.peek() - '0' > curr && k > 0){
                    stk.pop();
                    k--;
                }
                stk.push(num.charAt(i));
                
        }
        //System.out.println(stk);

        while(k > 0){
           stk.pop();
           k--;
        }

        while(!stk.isEmpty()){
            ans = stk.pop() + ans;
        }
        
        

        int index = 0;
        while (index < ans.length() && ans.charAt(index) == '0') {
            index++;
        }
        ans = ans.substring(index);

        

        return ans.isEmpty() ? "0" : ans;
        
    }
}


/*
----------------------BRUTE FORCE TOO HARD------------------------
-----------STRING BUILDER USE KARVU USEFUL (code below)-----------
class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();
        if (k >= n) {
            return "0";
        }
        
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            char curr = num.charAt(i);
            while (!stk.isEmpty() && stk.peek() > curr && k > 0) {
                stk.pop();
                k--;
            }
            stk.push(curr);
        }

        // Handle remaining k removals
        while (k > 0) {
            stk.pop();
            k--;
        }

        // Construct the result using StringBuilder
        StringBuilder ans = new StringBuilder();
        while (!stk.isEmpty()) {
            ans.append(stk.pop());
        }
        ans.reverse(); // Reverse since characters were popped in reverse order

        // Remove leading zeros
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}
*/

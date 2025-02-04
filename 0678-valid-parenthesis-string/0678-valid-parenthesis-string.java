// class Solution {
//     public boolean checkValidString(String s) {
//         int m = s.lastIndexOf('*');
//         return combinations(s.length(), s, 0, false, m);
//     }

//     public static boolean combinations(int length, String s, int index, boolean curr, int lastIndex) {
//         if (index == length) {
//             return checkParenthesis(s);
//         }

//         if (s.charAt(index) != '*') {
//             return combinations(length, s, index + 1, curr, lastIndex);
//         }

//         StringBuilder sb = new StringBuilder(s);
        
//         // Try '('
//         sb.setCharAt(index, '(');
//         boolean a = combinations(length, sb.toString(), index + 1, curr, lastIndex);
        
//         // Try ')'
//         sb.setCharAt(index, ')');
//         boolean b = combinations(length, sb.toString(), index + 1, curr, lastIndex);
        
//         // Try empty
//         sb.setCharAt(index, ' ');
//         boolean c = combinations(length, sb.toString(), index + 1, curr, lastIndex);
        
//         return a || b || c;
//     }

//     public static boolean checkParenthesis(String s) {
//         Stack<Character> stk = new Stack<>();
//         for (char curr : s.toCharArray()) {
//             if (curr == ' ') continue;
//             if (!stk.isEmpty() && stk.peek() == '(' && curr == ')') {
//                 stk.pop();
//             } else {
//                 stk.push(curr);
//             }
//         }
//         return stk.isEmpty();
//     }
// }

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen = Math.max(0, minOpen - 1);
                maxOpen--;
            } else { // '*'
                minOpen = Math.max(0, minOpen - 1);
                maxOpen++;
            }
            
            if (maxOpen < 0) return false;
        }
        
        return minOpen == 0;
    }
}

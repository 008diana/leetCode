//not my solution, took help from chatGPT
// liked how the parentehses are a part of the reversed string and then are deleted from the final answer in line 29 

class Solution {
    public String reverseParentheses(String s) {
        // Use a stack to keep track of the positions of opening parentheses
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        // Iterate through the characters in the StringBuilder
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                // Push the position of the opening parenthesis onto the stack
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                // Found a closing parenthesis, pop the last opening parenthesis position from the stack
                int j = stack.pop();
                // Reverse the substring between the opening and closing parentheses
                StringBuilder toReverse = new StringBuilder(sb.substring(j + 1, i));
                sb.replace(j, i + 1, toReverse.reverse().toString());
                // Adjust the position after replacement
                i = j + toReverse.length() - 1;
            }
        }

        // Build the result string, excluding the parentheses
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '(' && sb.charAt(i) != ')') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}

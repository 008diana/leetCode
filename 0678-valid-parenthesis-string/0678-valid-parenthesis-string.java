class Solution {
    public boolean checkValidString(String s) {
        int min = 0; // Minimum open parentheses count
        int max = 0; // Maximum open parentheses count (including '*')

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Guaranteed open, increase both min and max
                min++;
                max++;
            } else if (ch == ')') {
                // Guaranteed close, decrease both min and max
                min--;
                max--;
            } else if (ch == '*') {
                // Could be '(', ')' or ''
                min--;     // If '*' is ')'
                max++;     // If '*' is '('
            }

            // If max < 0, too many closing brackets
            if (max < 0) {
                return false;
            }

            // min can't be negative, reset to 0
            if (min < 0) {
                min = 0;
            }
        }

        // In the end, min == 0 means all opens are matched
        return min == 0;
    }
}

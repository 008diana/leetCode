//NMS, prefix sum, still don't understand why it works...
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int m = s.length();
        int[] shiftArray = new int[m + 1]; // Extra space for prefix sum adjustment

        // Apply shifts to the shiftArray
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            shiftArray[start] += (dir == 1 ? 1 : -1); // Increment or decrement start
            shiftArray[end + 1] -= (dir == 1 ? 1 : -1); // Adjust after end
        }

        // Compute prefix sum to get net shifts at each position
        int netShift = 0;
        for (int i = 0; i < m; i++) {
            netShift += shiftArray[i];
            shiftArray[i] = netShift; // Update shiftArray to store net shifts
        }

        // Build the resulting string with applied shifts
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            int shift = (shiftArray[i] % 26 + 26) % 26; // Ensure shift is positive
            char newChar = (char) ('a' + (ch - 'a' + shift) % 26);
            result.append(newChar);
        }

        return result.toString();
    }
}

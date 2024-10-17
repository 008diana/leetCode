// oaky, had to neetcode this one and had to gpt for syntax changes
class Solution {
    public int maximumSwap(int num) {
        // Convert the integer to a string for easier manipulation
        String numStr = Integer.toString(num);
        
        // Create an array to store the maximum digit from the right
        int[] maxArr = new int[numStr.length()];
        
        // Initialize the last element of maxArr to the last digit of numStr
        maxArr[numStr.length() - 1] = numStr.charAt(numStr.length() - 1) - '0';
        
        // This variable will keep track of the maximum value seen so far from the right
        int max = maxArr[numStr.length() - 1];
        
        // Fill maxArr with the maximum digit to the right of each position
        for (int i = numStr.length() - 2; i >= 0; i--) {
            maxArr[i] = Math.max(max, numStr.charAt(i) - '0'); // Corrected: subtract '0' to get the integer value
            max = maxArr[i];
        }

        // Now, look for the first place where a swap can occur
        for (int i = 0; i < numStr.length(); i++) {
            // If the current digit is less than the maximum digit to its right
            if (numStr.charAt(i) - '0' < maxArr[i]) {
                // Find the last occurrence of the maximum digit to the right of the current index
                for (int j = numStr.length() - 1; j > i; j--) {
                    if (numStr.charAt(j) - '0' == maxArr[i]) {
                        // Create a character array to swap the digits
                        char[] numArr = numStr.toCharArray();
                        // Swap the digits
                        char temp = numArr[i];
                        numArr[i] = numArr[j];
                        numArr[j] = temp;
                        // Convert the character array back to an integer
                        return Integer.parseInt(new String(numArr)); // Return the new number after swap
                    }
                }
            }
        }

        // If no swap can be made, return the original number
        return num;
    }
}

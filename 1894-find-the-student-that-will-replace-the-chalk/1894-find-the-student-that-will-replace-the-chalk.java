//modulo be interesting
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;

        // Calculate the total amount of chalk used in one round
        for (int c : chalk) {
            totalChalk += c;
        }

        if(totalChalk > k) {
            for (int i = 0; i < chalk.length; i++) {
                if (chalk[i] > k) {
                    return i;
                }
                k -= chalk[i];
            }
        }
        
        else{
             // Find the remainder of chalk after removing complete rounds
            k %= totalChalk;

            // Identify which student will replace the chalk
            for (int i = 0; i < chalk.length; i++) {
                if (chalk[i] > k) {
                    return i;
                }
                k -= chalk[i];
            }
        }

       

        return -1; // This line should never be reached
    }
}

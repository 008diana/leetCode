// it took me modifying at each test case and stopping at 2 more submissions to get the ans. but completed within 25 minutes, so... happy
//tried more optimized
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int m = rolls.length;
        int k = m + n;
        int[] ansArr = new int[n];
        for(int i = 0; i < m; i++) {
            sum += rolls[i];
        }
        System.out.println(sum);
        int mul = mean * k;
        System.out.println(mul);
        int y = mul - sum;
        System.out.println(y);
        float ans = ((float) y )/ ((float) n);
        System.out.println(ans);
        int[] empty = new int[0];
        if(ans > 6 || ans < 1) {
            return empty;
        }
    
        // int ansSum = 0;
        // boolean bool = true;
        // while(bool){
        //     for(int i = 0 ; i < n; i++){
        //         if(ansSum == y) {
        //             bool = false;
        //             break;
        //         }
        //     ansArr[i] += 1;
        //     ansSum++;
        // }
        // }

        int initial = y / n;
        int left = y - (initial * n);
        for(int i = 0; i < n; i++) {
            ansArr[i] = initial;
        }

        int ansSum = 0;
        boolean bool = true;
        while(bool){
            for(int i = 0 ; i < n; i++){
                if(ansSum == left) {
                    bool = false;
                    break;
                }
            ansArr[i] += 1;
            ansSum++;
        }
        }
        
        
        
        return ansArr;
    }
}
/*
neetcode optimised:
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        // Step 1: Calculate the total number of rolls (m)
        int m = rolls.length;
        
        // Step 2: Calculate the total sum of all rolls
        int totalSum = (m + n) * mean;
        
        // Step 3: Calculate the sum of the given rolls
        int currentSum = Arrays.stream(rolls).sum();
        
        // Step 4: Calculate the missing sum (sum of the missing rolls)
        int missingSum = totalSum - currentSum;
        
        // Step 5: Validate if the missing sum is valid
        if (missingSum < n || missingSum > 6 * n) {
            // If the missing sum is not valid, return an empty array
            return new int[0];
        }

        // Step 6: Create an array to store the missing rolls
        int[] result = new int[n];
        
        // Step 7: Fill the missing rolls greedily
        for (int i = 0; i < n; i++) {
            // Assign the maximum possible value to each slot
            result[i] = Math.min(6, missingSum - (n - i - 1));
            // Update the remaining missing sum
            missingSum -= result[i];
        }

        return result;
    }

*/
// it took me modifying at each test case and stopping at 2 more submissions to get the ans. but completed within 25 minutes, so... happy
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
    
        int ansSum = 0;
        boolean bool = true;
        while(bool){
            for(int i = 0 ; i < n; i++){
                if(ansSum == y) {
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
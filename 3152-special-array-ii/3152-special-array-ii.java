class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] askHere = new int[n];
        askHere[0] = 0;
        int counter = 0;
        boolean[] ans = new boolean[q];
        Arrays.fill(ans, true);
        for(int i = 0 ; i < n - 1; i++){
            if ((nums[i] + nums[i+1]) % 2 == 0){
                counter = counter+1;
                askHere[i + 1] = counter;
            }
            else{
                askHere[i+ 1] = counter;
            }
            
        }
        //System.out.println(Arrays.toString(askHere));
        for (int i = 0; i < q; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            //System.out.println(askHere[end]);
            //System.out.println(askHere[start]);
            if(askHere[end] - askHere[start] > 0){
                
                ans[i] = false;
            }
        }
        return ans;
    }
}
/*
--------------------------ATTEMPT 1-------------------------------------
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int q = queries.length;
        boolean[] ans = new boolean[q];
        Arrays.fill(ans, true);
        
        for (int i = 0; i < q; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            for(int j = start; j < end; j++){
                if((nums[j] + nums[j + 1]) % 2 == 0){
                    ans[i] = false;
                    break;
                }
            }
            
        }
        
    return ans;
    }
}

--------------------------ATTEMPT 2-------------------------------------
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        boolean askHere[] = new boolean[n - 1];
        boolean[] ans = new boolean[q];
        Arrays.fill(ans, true);
        for(int i = 0 ; i < n - 1; i++){
            if ((nums[i] + nums[i+1]) % 2 == 0){
                askHere[i] = false;
            }
            else{
                askHere[i] = true;
            }
            
        }
        for (int i = 0; i < q; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            for(int j = start; j < end; j++){
                if(askHere[j] == false){
                    ans[i] = false;
                    break;
                }
            }
        }
        return ans;
    }
}
 */


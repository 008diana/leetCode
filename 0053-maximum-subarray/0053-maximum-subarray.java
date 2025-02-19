class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = Integer.MIN_VALUE;
        int curr = 0;
        for(int i = 0; i < n; i++){
            curr += nums[i];
            sum = Math.max(curr, sum);
            if(curr < 0){
                curr = 0;
            }

        }
        return sum;
    }
}

/*
------------------------------BETTER SOLUTION---------------------------
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
       
        for(int i = 0; i < n; i++){
            int sum = nums[i];
            //System.out.print(sum + "  ");
            max = Math.max(max, sum);
            for(int j = i + 1; j < n; j++){
                sum += nums[j];
                //System.out.print(sum + "  ");
                max = Math.max(max, sum);
            }
            //System.out.println();
        }
        return max;
    }
}
*/
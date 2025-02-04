class Solution {
    public int maxAscendingSum(int[] nums) {
      int maxSum = 0;
      int currSum = nums[0];
      int n = nums.length;
      int i = 0;
      while(i < n - 1){
        if(nums[i] < nums[i+1]){
            currSum += nums[i+1];
            //System.out.print(currSum + "  ");
        }
        else{
            maxSum = Math.max(maxSum, currSum);
            //System.out.println("maxSum: " + maxSum);
            currSum = nums[i + 1];
        }
        i++;
      } 
      maxSum = Math.max(maxSum, currSum);
      return maxSum; 
    }
}
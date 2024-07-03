// understood the solution, implemented the code by myself (okay, a little help from gpt)
class Solution {
    public int minDifference(int[] nums) {
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if(nums.length <= 4){
            return 0;
        }
        else{
            // Change 0 smallest and 3 largest elements
            min = Math.min(min, nums[n-4] - nums[0]);
            // Change 1 smallest and 2 largest elements
            min = Math.min(min, nums[n-3] - nums[1]);
            // Change 2 smallest and 1 largest element
            min = Math.min(min, nums[n-2] - nums[2]);
            // Change 3 smallest and 0 largest elements
            min = Math.min(min, nums[n-1] - nums[3]);

            return min;
        }
    }
}
//to do : create largest and smallest so that the difference is minimum in three moves
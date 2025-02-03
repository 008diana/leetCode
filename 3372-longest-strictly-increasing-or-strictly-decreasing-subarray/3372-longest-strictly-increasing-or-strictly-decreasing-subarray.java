class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int maxCounter = 1;
        int currCounter = 1;
        int n = nums.length;
        int i = 0;
        
        while (i < n - 1) {
            if (nums[i] > nums[i + 1]) {
                currCounter = 1;
                while (i < n - 1 && nums[i] > nums[i + 1]) {  // Changed order of conditions
                    currCounter++;
                    i++;
                }
                maxCounter = Math.max(maxCounter, currCounter);
            }
            else if (nums[i] < nums[i + 1]) {
                currCounter = 1;
                while (i < n - 1 && nums[i] < nums[i + 1]) {  // Changed order of conditions
                    currCounter++;
                    i++;
                }
                maxCounter = Math.max(maxCounter, currCounter);
            }
            else {
                i++;
            }
        }
        return maxCounter;
    }
}
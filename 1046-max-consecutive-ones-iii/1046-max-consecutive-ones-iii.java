class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeroCount = 0;
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        while(end < n && start < n){
            if(nums[end] == 1){
                max = Math.max(end - start + 1, max);
                end++;
                //System.out.println(max + " first " + "end = " + end +" start " + start + " zero count = " + zeroCount);
            }
            else if(nums[end] == 0 && zeroCount != k){
                max = Math.max(end - start + 1, max);
                zeroCount++;
                end++;
                //System.out.println(max + " second " + "end = " + end +" start " + start + " zero count = " + zeroCount);
            }
            else{
                max = Math.max(end - start, max);
                while(nums[start] != 0){
                    start++;
                }
                start++;
                zeroCount--;
                //System.out.println(max + " third " + "end = " + end +" start " + start + " zero count = " + zeroCount);
            }
        }
        return max;
    }
}
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int rotations = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                rotations++;
            }
            
            // More than one rotation point means it can't be made non-decreasing
            if (rotations > 1) {
                return false;
            }
        }
        
        return true;
    }
}
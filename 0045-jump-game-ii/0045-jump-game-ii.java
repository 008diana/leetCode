class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }

        // 'maxIndex' represents the maximum reach from the current position.
        // It's a more accurate name for your original variable.
        int maxReach = nums[0];
        
        // 'currentJumpEnd' is the farthest index we can reach with the current number of jumps.
        // We'll use this to decide when to increment steps.
        int currentJumpEnd = nums[0];
        
        int steps = 1;

        // Iterate from the second element up to the second-to-last.
        for(int i = 1; i < n - 1; i++){
            // Update the maximum reach we can achieve from any position
            // within the current jump.
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we've reached the end of the current jump, we need to take another step.
            if (i == currentJumpEnd) {
                steps++;
                // The new jump's end is now the farthest we could reach.
                currentJumpEnd = maxReach;
            }
        }
        
        return steps;
    }
}
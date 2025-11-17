class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int prev = 0;
        int next = 0;
        int r = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                prev = i;
                r = i;
                break;
            }

        }
        for(int i = r + 1; i < n; i++){
            if(nums[i] == 1){
                next = i;
                if(next - prev - 1 < k){
                    return false;
                }
                prev = next;
            }
        }
        return true;
    }
}
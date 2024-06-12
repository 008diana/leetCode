class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int r = 0;
        int[] nums2 = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums2[i] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums2[i] == 0){
                nums[r] = 0;
                r++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums2[i] == 1){
                nums[r] = 1;
                r++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums2[i] == 2){
                nums[r] = 2;
                r++;
            }
        }
    }
}
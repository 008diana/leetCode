class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] positives = new int[n / 2];
        int p = 0;
        int[] negatives = new int[n / 2];
        int q = 0;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            if(curr < 0){
                negatives[q] = curr;
                q++;
            }
            else{
                positives[p] = curr;
                p++;
            }
        }
        for(int i = 0; i < n; i++){
            if( i % 2 == 0){
                nums[i] = positives[i/2];
            }
            else{
                nums[i] = negatives[i/2];
            }
        }
        return nums;
    }
}
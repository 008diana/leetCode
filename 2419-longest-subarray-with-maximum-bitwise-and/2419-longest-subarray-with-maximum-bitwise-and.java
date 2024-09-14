class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length; i++){
            if (nums[i] >= max){
                max = nums[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        int counter = 1;
        list.add(counter);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == max && nums[i + 1]== max){
                counter++;   
            }
            else if(nums[i] == max && nums[i +1] != max){
                list.add(counter);
                counter = 1;
            }
        }
        if (nums[nums.length - 1] == max) {
            list.add(counter);  // Add the last subarray's count if the loop ends with max
        }
        return Collections.max(list);
    }
}
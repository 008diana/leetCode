class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int j = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(visited.contains(nums[i])){
                nums[i] = 0;
            }
            else{
                nums[j] = nums[i];
                j++;
                visited.add(nums[i]);
                k++;
            }
            
        }
        return k;
    }
}
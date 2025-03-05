class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        int check = (n/3);
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n - check; i++){
            if(nums[i] == nums[i + check] && !visited.contains(nums[i])){
                result.add(nums[i]);
                visited.add(nums[i]);
            }
        }

        return result;

    }
}
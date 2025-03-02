class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int counter = 0;
        //int[] prefixSum = new int[n];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            
            int required = sum - k;
            if(map.containsKey(required)) {
                counter += map.get(required);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }
}
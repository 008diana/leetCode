class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n ; j++){
                int curr = nums[i] * nums[j];
                if(!map.containsKey(curr)){
                    map.put(curr, 1);
                }
                else{
                    map.put(curr, map.get(curr) + 1);
                }
            }
        }

            for (int val : map.values()) {
            if (val > 1) {
                counter += 8 * (val * (val - 1)) / 2;
            }
            }
        
        return counter;
    }
}

//if you find one set of 4 nums, there are 8 possible combinations. just find the set of different combinations which satisfy the given condition and multiply by 8.
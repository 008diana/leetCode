//finally easy XD
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(numbers.contains(nums[i])){
                numbers.remove(nums[i]);
            }
            else{
                numbers.add(nums[i]);
            }
        }
        return numbers.iterator().next();
    }
}
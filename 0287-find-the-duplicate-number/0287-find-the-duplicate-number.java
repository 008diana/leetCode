/*
CORRECT APPROACH FOR CONSTANT EXTRA SPACE (TORTOISE HARE APPROACH)
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        // Step 1: Initialize the tortoise and hare
        int tortoise = nums[0];
        int hare = nums[0];
        
        // Step 2: Find the intersection point in the cycle
        do {
            tortoise = nums[tortoise];  // Move tortoise one step
            hare = nums[nums[hare]];    // Move hare two steps
        } while (tortoise != hare);      // Keep moving until they meet
        
        // Step 3: Find the entrance to the cycle (duplicate number)
        tortoise = nums[0];  // Reset tortoise to the start of the array
        while (tortoise != hare) {  // Move both one step at a time until they meet
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        // Step 4: Return the entrance point, which is the duplicate number
        return hare;
    }
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                ans = nums[i];
            }
            else{
                hm.put(nums[i], 1);
            }
        }
        return ans;
    }
}
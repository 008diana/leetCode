//pretty proud!
class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        if(checkIfSorted(nums)){
            return true;
        }
        else{
            
            int prevMax = nums[0];
            int prevCount = Integer.bitCount(nums[0]);
            int min = Integer.MAX_VALUE;
            int max = 0;
            int i = 1;
            while(i < n){
                int count = Integer.bitCount(nums[i]);
                if(prevCount != count){
                    min = nums[i];
                    max = nums[i];
                    prevCount = count;
                    i++;
                    while(i < n && Integer.bitCount(nums[i]) == prevCount){
                        //count = Integer.bitCount(nums[i]);
                        min = Math.min(min, nums[i]);
                        max = Math.max(max, nums[i]);
                        i++;
                    }

                    if(prevMax > min){
                        return false;
                    }
                    
                        prevMax = max;                        
                    
                }
                else{
                    
                    prevMax = Math.max(prevMax, nums[i]);
                    i++;
                }
            }
        }
        return true;
        
    }
    public static boolean checkIfSorted(int[] nums){
        int n =  nums.length;
        for(int i = 0; i < n- 1 ; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
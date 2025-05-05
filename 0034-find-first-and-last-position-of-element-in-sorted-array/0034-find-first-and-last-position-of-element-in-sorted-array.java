class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int [2];
        result[0] = firstOcc(nums, target);
        result[1] = lastOcc(nums, target);
        return result;
    }

    public static int firstOcc(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n -1; 
        int solution = -1;
        
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if (nums[mid] == target){
                solution = mid;
                high = mid - 1;
            }
            else{
                high = mid -1;
            }
        }
        return solution;
        
    }

    public static int lastOcc(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n -1; 
        int solution = -1;
        
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if (nums[mid] == target){
                solution = mid;
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return solution;
    }
}
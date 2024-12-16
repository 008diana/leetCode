class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            minHeap.add(nums[i]);
        }
        for(int i = 0; i < k; i++){
            int number = minHeap.poll();
            nums = searchAndReplace(number, nums, multiplier);
            //print(nums);
            minHeap.add(number * multiplier);
        }
        return nums;
    }
    public static int[] searchAndReplace(int number, int[] nums, int multiplier){
        int n = nums.length;
        for(int i = 0; i < n;i ++){
            if(nums[i] == number){
                nums[i] = number * multiplier;
                break;
            }
        }
        return nums;
    }
    // public static void print(int[] arr){
    //     for (int i = 0; i < arr.length; i++){
    //         System.out.print(arr[i] + " ");
    //     }
    //     System.out.println();
    // }
}

/*
-------------------SIMPLER APPROACH IN THE SOLUTIONS SECTION--------------------
CAUSE LOOK AT THE CONSTRAINTS
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] arr = new int[2];

        for (int i = 0; i < k; i++) {
            arr = getMin(nums);
            nums[arr[1]] = arr[0] * multiplier;
        }

        return nums;
    }

    private int[] getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }

        return new int[] { min, idx };
    }

}
*/
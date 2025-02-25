class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            Arrays.sort(nums);
            return;
        }

        for(int i = n -1; i > index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        int iterations = (n - 1 - index)/ 2;
        int i = 1;

        while(iterations > 0){
            int temp = nums[index + i];
            nums[index + i] = nums[n - i];
            nums[n - i] = temp;
            i++;
            iterations--;
        }
        return;
    }
}
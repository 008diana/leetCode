class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int curr = nums[0];
        int counter = 1;
        for(int i = 1; i < n; i++){
            if(counter != 0){
                if(nums[i] != curr){
                    counter--;
                }
                else{
                    counter++;
                }
            }
            else{
                curr = nums[i];
                counter = 1; 
            }
        }
        counter = 0;
        //checking if the current element is the n/2 se greater..
        for(int i = 0; i < n; i++){
            if(nums[i] == curr){
                counter++;
            }
        }
        if(counter > (n/2)){
            return curr;
        }
        else{
            return -1;
        }
    }
}
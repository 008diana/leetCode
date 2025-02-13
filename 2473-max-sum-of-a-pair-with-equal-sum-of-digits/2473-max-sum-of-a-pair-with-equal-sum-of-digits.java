class Solution {
    public int maximumSum(int[] nums) {
        int result = -1;
        int n = nums.length;
        int digitSum = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            digitSum = digiSum(curr);
            
            if(map.containsKey(digitSum)){
                if((map.get(digitSum)).size() == 1){
                    map.get(digitSum).add(nums[i]);
                    ArrayList<Integer> list = map.get(digitSum);
                    if(list.get(0) > list.get(1)){
                        int temp = list.get(0);
                        list.set(0, list.get(1));
                        list.set(1, temp);
                    }
                    result = Math.max(result, list.get(0) + list.get(1));
                }
                else{
                    ArrayList<Integer> list = map.get(digitSum);
                    if(list.get(0) < nums[i] && nums[i] < list.get(1)){
                        list.set(0, nums[i]);
                    }
                    if(nums[i] > list.get(1)){
                        list.set(0, list.get(1));
                        list.set(1, nums[i]);
                    }
                    result = Math.max(result, list.get(0) + list.get(1));
                }
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(digitSum, list);
            }
        }
        return result;
    }

    public static int digiSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10; 
            number /= 10;       
        }
        return sum;
    }
}
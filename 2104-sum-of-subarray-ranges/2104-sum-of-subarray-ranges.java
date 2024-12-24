class Solution {
    public long subArrayRanges(int[] nums) {
        long min = findMinSum(nums);
        long max = findMaxSum(nums);
        return max - min;
    }

    public static long findMinSum(int[] nums) {

        int n = nums.length;
        int[] right = new int[n];
        right = nse (nums);
        int[] left = new int[n];
        left = pse (nums);//pse is considering equal as well
        long sum = 0;

        for(int i = 0; i < n; i++){
            sum += ((right[i] - i) * (i -left[i])) *(long) nums[i];
        }

        return sum;
    }

    public static int[] nse (int[] nums){

        int n = nums.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(0);

        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && nums[stk.peek()] > nums[i]){
                map.put(stk.pop(), i);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            map.put(stk.pop(), n);
        }

        for(int i = 0; i < n; i++){
            ans[i] = map.get(i);
        }
        return ans;
    }

    public static int[] pse(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!stk.isEmpty() && nums[stk.peek()] >= nums[i]){
                map.put(stk.pop(), i);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            map.put(stk.pop(), -1);
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(i);
        }
        return ans;
    }

    public static long findMaxSum(int[] nums){

        int n = nums.length;
        int[] right = new int[n];
        right = nge(nums);
        int[] left = new int[n];
        left = pge(nums);//pge is considering equal as well
        long sum = 0;

        for(int i = 0; i < n; i++){
            sum += ((right[i] - i) * (i -left[i])) *(long) nums[i];
        }

        return sum;        
    }

    public static int[] nge (int[] nums){

        int n = nums.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(0);

        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i]){
                map.put(stk.pop(), i);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            map.put(stk.pop(), n);
        }

        for(int i = 0; i < n; i++){
            ans[i] = map.get(i);
        }
        return ans;
    }

    public static int[] pge(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i]){
                map.put(stk.pop(), i);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            map.put(stk.pop(), -1);
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(i);
        }
        return ans;
    }


}
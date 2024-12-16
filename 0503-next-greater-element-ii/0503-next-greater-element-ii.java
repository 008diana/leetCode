class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();

        stk.push(0);

        for (int i = 1; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                map.put(stk.pop(), nums[i]);
            }
            stk.push(i); 
        }


        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                map.put(stk.pop(), nums[i]);
            }
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

/*
------------------ATTEMPT 1--------------------------
faliure cause one pass solution on stack is not logicallypossible due to this test case:
Input
nums =
[1,2,3,2,1]

Use Testcase
Output
[2,3,-1,3,3]
Expected
[2,3,-1,3,2]

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();

        stk.push(0);

        int bottom = nums[0];
        int bottomIndex = 0;

        for (int i = 1; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                map.put(stk.pop(), nums[i]);
            }
            if (stk.isEmpty()) {
                bottom = nums[i];
                bottomIndex = i;
            }
            stk.push(i); 
        }


        while (!stk.isEmpty()) {
            if(nums[stk.peek()] == bottom){
                map.put(stk.pop(), -1);
            }
            else{
                map.put(stk.pop(), bottom);
            } 
        }

        map.put(bottomIndex, -1);

        for (int i = 0; i < n; i++) {
            ans[i] = map.getOrDefault(i, -1);
        }

        return ans;
    }
}
*/
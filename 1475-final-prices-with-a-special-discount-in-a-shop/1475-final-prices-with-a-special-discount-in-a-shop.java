class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] ans = new int[n];

        Stack<Integer> stk = new Stack<>();
        stk.push(0);

        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && prices[stk.peek()] >= prices[i]){
                int index = stk.pop();
                ans[index] = prices[index] - prices[i];
            }
            stk.push(i);
        }

        while(!stk.isEmpty()){
            int index = stk.pop();
            ans[index] = prices[index];
        }

        return ans;

    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int least = Integer.MAX_VALUE;
        int profit = 0;
        int currProfit = 0;

        for(int i = 0; i <  prices.length ; i++){
            if(prices[i] < least){
                least = prices[i];
            }
            currProfit = prices[i] - least;
            profit = Math.max(profit, currProfit);
            
        }
        
        return profit;
        
    }
}
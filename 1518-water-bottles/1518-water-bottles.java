class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int currBottles = numBottles;
        int sum = numBottles;
        while(currBottles >= numExchange){
            sum = sum + (currBottles/numExchange);
            currBottles = (currBottles/numExchange) + currBottles  - ((currBottles/numExchange) * numExchange);
        }
        return sum;
    }
}
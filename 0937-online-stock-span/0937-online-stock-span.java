class StockSpanner {
    Stack<int[]> stk;
    int counter;
    
    public StockSpanner() {
        stk = new Stack<>();
        counter = -1;
    }
    
    public int next(int price) {
        counter++;
        int priceN = -price;
        
        while(!stk.isEmpty() && stk.peek()[0] >= priceN) {
            stk.pop();
        }
        
        int peek = stk.isEmpty() ? -1 : stk.peek()[1];
        stk.push(new int[] {priceN, counter});
        
        return counter - peek;
    }
}
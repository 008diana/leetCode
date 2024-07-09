class Solution {
    public double averageWaitingTime(int[][] customers) {
        int arr;
        int timetaken;
        int finish = 0;
        long waitingTime = 0;
        for(int i = 0; i < customers.length; i++){
                arr = customers[i][0];
                timetaken = customers[i][1];
                if(arr > finish){
                    finish = arr + timetaken;
                }
                else{
                    finish = finish + timetaken;
                }
                waitingTime += finish - arr; 
        }
        double ans = (double) waitingTime / customers.length;
        return ans;
    }
}
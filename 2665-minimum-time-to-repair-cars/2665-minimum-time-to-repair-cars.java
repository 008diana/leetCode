class Solution {
    public boolean isPossible(int[] ranks, int cars, long time){
        int size  = ranks.length;
        long count = 0;

        for(int i = 0; i< size; i++){
            long numberOfCars = (int)Math.sqrt(time/ranks[i]);
            count = count + numberOfCars;
        }

        if(count >= cars)
            return true;
        else
            return false;
        
    }
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = Integer.MAX_VALUE;
        for(int ele: ranks){
            high = Math.min(ele,high);
        }

        high = (long)high*cars*cars;
        long ans = high;

        while(low<=high){
            long mid = low + (high-low)/2;
            if(isPossible(ranks,cars,mid)){
                ans  = mid;
                high = mid-1;
            }else{
                low  = mid+1;
            }
        }
        return ans;
    }
}
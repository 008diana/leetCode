//will brute force work?
//nope
//successfully implemented priority queue!!!
class Solution {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            pq.offer(nums[i]);
        }
        long score = 0;
        int polled;
        for(int i = 0; i < k; i++){
            polled = pq.poll();
            score = score + polled;
            int toAdd = ceil(polled);
            pq.offer(toAdd);
        }
        return score;
    }

    public static int ceil (int number){
        if(number % 3 == 0){
            return number/3;
        }
        return (number / 3) + 1;
    }
}
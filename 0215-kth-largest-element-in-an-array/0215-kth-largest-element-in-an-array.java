//why did this take me 10 minutes? sure it's a medium?
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        for(int i = 0; i < k - 1; i++){
            pq.poll();
        }
        int s = pq.poll();
        return s;
    }
}

/*
minheap, but better:
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        
        return minHeap.peek();
    }
}
*/
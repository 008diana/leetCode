//NMS sokution dekh ke bhi dekhnaa padaa, anyways learnt new stuff
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && i - dq.peekFirst() == k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k - 1){
                ans[start] = nums[dq.peekFirst()];
                start++;
            }
        }
        return ans;
    }
}
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max heap to always access the largest gift value
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform the operation k times on the largest elements
        for (int i = 0; i < k; i++) {
            int maxGift = maxHeap.poll(); // Extract the largest value
            maxHeap.add(operation(maxGift)); // Add back the reduced value
        }

        // Sum up the remaining elements in the heap
        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }
        return sum;
    }

    public static int operation(int giftVal) {
        return (int) Math.sqrt(giftVal);
    }
}

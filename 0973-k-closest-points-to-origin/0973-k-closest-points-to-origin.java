// fpund out that the how to link the answer! that you can pass an array and the heap will sort based on the index you like, good experience!
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Min-Heap to store the points based on their distance to the origin
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]) // Compare based on the squared distance
        );

        // Iterate through each point
        for (int[] point : points) {
            // Calculate the squared distance from the origin
            int distanceSquared = point[0] * point[0] + point[1] * point[1];

            // Add the distance and point to the min-heap
            minHeap.offer(new int[]{distanceSquared, point[0], point[1]});
        }

        // Create an array to hold the k closest points
        int[][] result = new int[k][2];

        // Poll the first k elements from the min-heap
        for (int i = 0; i < k; i++) {
            int[] closestPoint = minHeap.poll();
            result[i][0] = closestPoint[1]; // x-coordinate
            result[i][1] = closestPoint[2]; // y-coordinate
        }

        return result;
    }
}
   
/*
calculate the distance of each point and add it to a min heap
then poll one by one k times
that is the answer
*/
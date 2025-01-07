import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adj = new int[n + 1][n + 1];

        // Initialize adjacency matrix with a large value (infinity-like) for no direct paths
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }

        // Fill adjacency matrix with given edges
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            adj[source][destination] = travelTime;
        }

        // Min-heap to track the next node to process, sorted by cumulative time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] { k, 0 }); // Start with the source node `k`

        // Visited set and result initialization
        HashSet<Integer> visited = new HashSet<>();
        int res = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currNode = curr[0];
            int currTime = curr[1];

            // Skip if node is already visited
            if (visited.contains(currNode)) {
                continue;
            }

            visited.add(currNode);
            res = Math.max(res, currTime);

            // Traverse neighbors
            for (int i = 1; i <= n; i++) { // Start from 1 since node indices are 1-based
                if (adj[currNode][i] != Integer.MAX_VALUE && !visited.contains(i)) {
                    minHeap.add(new int[] { i, currTime + adj[currNode][i] });
                }
            }
        }

        // If not all nodes are visited, return -1
        return visited.size() == n ? res : -1;
    }
}

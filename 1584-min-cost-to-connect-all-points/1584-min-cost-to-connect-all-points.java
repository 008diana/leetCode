//yes this took me 3 days. yes I am proud. 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n  = points.length;
        int cost = 0;

        // Make a distance matrix
        int[][] distance = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(i == j){
                    distance[i][j] = Integer.MAX_VALUE;
                } else {
                    distance[i][j] = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                }
            }
        }

        // Declare a HashSet to track visited nodes
        HashSet<Integer> visited = new HashSet<>();

        // Declare a min-heap with a custom comparator
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Add the first vertex (0) with a distance of 0
        visited.add(0);
        int column = 0;

        // Initialize the heap with the distances from the first point
        for (int i = 1; i < n; i++) {
            minHeap.offer(new int[] {distance[0][i], i});
        }

        // Prim's algorithm to connect all points
        while (visited.size() != n) {
            // Poll the minimum element from the heap (shortest distance)
            int[] closest = minHeap.poll();
            int dist = closest[0];
            int nextPoint = closest[1];

            // If the point is already visited, skip it
            if (visited.contains(nextPoint)) continue;

            // Add this point to the visited set and add its cost
            visited.add(nextPoint);
            cost += dist;

            // Add new edges from the current point to unvisited points
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    minHeap.offer(new int[] {distance[nextPoint][i], i});
                }
            }
        }

        return cost;
    }
}

//NMS. Go through Readme for more info!

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ansMatrix = new int[k][k];
        
        int[] rowOrder = topologicalSort(k, rowConditions);
        int[] colOrder = topologicalSort(k, colConditions);

        if (rowOrder == null || colOrder == null) {
            return new int[0][0]; // If there's a cycle, return an empty matrix.
        }

        int[] posInRow = new int[k + 1];
        int[] posInCol = new int[k + 1];

        for (int i = 0; i < k; i++) {
            posInRow[rowOrder[i]] = i;
            posInCol[colOrder[i]] = i;
        }

        for (int i = 1; i <= k; i++) {
            ansMatrix[posInRow[i]][posInCol[i]] = i;
        }

        return ansMatrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] inDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] condition : conditions) {
            int u = condition[0], v = condition[1];
            graph[u].add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[k];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;

            for (int neighbor : graph[node]) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return index == k ? order : null; // If not all nodes are processed, there's a cycle.
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int k = 4;
        int[][] rowConditions = {{1, 3}, {2, 3}, {4, 3}, {3, 4}};
        int[][] colConditions = {{2, 1}, {3, 2}, {4, 1}, {4, 3}};

        int[][] result = solver.buildMatrix(k, rowConditions, colConditions);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.add(new int[]{0, 0});
        visited.add("0,0");

        return BFS(x, y, target, visited, queue);
    }

    public static boolean BFS(int x, int y, int target, HashSet<String> visited, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int a = curr[0];
            int b = curr[1];

            if (a + b == target) return true;

            // Generate next possible states
            List<int[]> nextStates = Arrays.asList(
                new int[]{x, b},      // Fill Jug 1
                new int[]{a, y},      // Fill Jug 2
                new int[]{0, b},      // Empty Jug 1
                new int[]{a, 0},      // Empty Jug 2
                new int[]{a - Math.min(a, y - b), b + Math.min(a, y - b)}, // Pour Jug 1 -> Jug 2
                new int[]{a + Math.min(b, x - a), b - Math.min(b, x - a)}  // Pour Jug 2 -> Jug 1
            );

            // Process next states
            for (int[] state : nextStates) {
                String key = state[0] + "," + state[1];
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(state);
                }
            }
        }
        return false;
    }
}

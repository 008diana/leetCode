// class Solution {
//     public int[][] highestPeak(int[][] isWater) {
//         int m = isWater.length;
//         int n = isWater[0].length;

//         int[][] result = new int[m][n];
//         HashSet<String> visited = new HashSet<>();
//         Queue<int[]> queue = new LinkedList<>();

//         // Initialize the result and queue
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (isWater[i][j] == 1) {
//                     result[i][j] = 0;
//                     queue.add(new int[]{i, j});
//                     visited.add(i + "," + j); // Add to visited
//                 } else {
//                     result[i][j] = -1;
//                 }
//             }
//         }

//         //print(result);

//         // BFS
//         while (!queue.isEmpty()) {
//             int[] curr = queue.poll();

//             int[] left = left(curr, result);
//             if (left[0] != -1 && left[1] != -1 && !visited.contains(left[0] + "," + left[1])) {
//                 queue.add(left);
//                 result[left[0]][left[1]] = result[curr[0]][curr[1]] + 1;
//                 visited.add(left[0] + "," + left[1]);
//             }

//             int[] right = right(curr, result);
//             if (right[0] != -1 && right[1] != -1 && !visited.contains(right[0] + "," + right[1])) {
//                 queue.add(right);
//                 result[right[0]][right[1]] = result[curr[0]][curr[1]] + 1;
//                 visited.add(right[0] + "," + right[1]);
//             }

//             int[] top = top(curr, result);
//             if (top[0] != -1 && top[1] != -1 && !visited.contains(top[0] + "," + top[1])) {
//                 queue.add(top);
//                 result[top[0]][top[1]] = result[curr[0]][curr[1]] + 1;
//                 visited.add(top[0] + "," + top[1]);
//             }

//             int[] bottom = bottom(curr, result);
//             if (bottom[0] != -1 && bottom[1] != -1 && !visited.contains(bottom[0] + "," + bottom[1])) {
//                 queue.add(bottom);
//                 result[bottom[0]][bottom[1]] = result[curr[0]][curr[1]] + 1;
//                 visited.add(bottom[0] + "," + bottom[1]);
//             }
//         }

//         return result;
//     }

//     public static void print(int[][] arr) {
//         int m = arr.length;
//         int n = arr[0].length;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 System.out.print(arr[i][j] + "  ");
//             }
//             System.out.println();
//         }
//     }

//     public static int[] left(int[] curr, int[][] result) {
//         int i = curr[0];
//         int j = curr[1];
//         int[] coordinate = new int[2];
//         coordinate[0] = -1;
//         coordinate[1] = -1;
//         if (j > 0) { // Fix the boundary check
//             coordinate[0] = i;
//             coordinate[1] = j - 1;
//         }
//         return coordinate;
//     }

//     public static int[] right(int[] curr, int[][] result) {
//         int i = curr[0];
//         int j = curr[1];
//         int[] coordinate = new int[2];
//         coordinate[0] = -1;
//         coordinate[1] = -1;
//         if (j < result[0].length - 1) { // Fix the boundary check
//             coordinate[0] = i;
//             coordinate[1] = j + 1;
//         }
//         return coordinate;
//     }

//     public static int[] top(int[] curr, int[][] result) {
//         int i = curr[0];
//         int j = curr[1];
//         int[] coordinate = new int[2];
//         coordinate[0] = -1;
//         coordinate[1] = -1;
//         if (i > 0) { // Fix the boundary check
//             coordinate[0] = i - 1;
//             coordinate[1] = j;
//         }
//         return coordinate;
//     }

//     public static int[] bottom(int[] curr, int[][] result) {
//         int i = curr[0];
//         int j = curr[1];
//         int[] coordinate = new int[2];
//         coordinate[0] = -1;
//         coordinate[1] = -1;
//         if (i < result.length - 1) { // Fix the boundary check
//             coordinate[0] = i + 1;
//             coordinate[1] = j;
//         }
//         return coordinate;
//     }
// }
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize result matrix and queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    result[i][j] = -1; // Mark unvisited cells
                }
            }
        }
        
        // Directions for BFS
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // BFS to compute heights
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : directions) {
                int x = curr[0] + dir[0], y = curr[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && result[x][y] == -1) {
                    result[x][y] = result[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        
        return result;
    }
}



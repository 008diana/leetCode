// class Solution {
//     public int trapRainWater(int[][] heightMap) {

//         int m = heightMap.length;
//         int n = heightMap[0].length;
//         System.out.println("m : " + m);
//         System.out.println("n : " + n);


//         int[][] left = new int[m][n];
//         for(int i = 0; i < m; i++){
//             left[i][0] = heightMap[i][0];
//         }
//         for(int i = 0; i < m; i++){
//             for(int j = 1; j < n; j++){
//                 left[i][j] = Math.max(left[i][j - 1], heightMap[i][j - 1]);
//             }
//         }
//         System.out.println("Left Array:");
//         print(left);


//         int[][] right = new int[m][n];
//         for(int i = 0; i < m; i++){
//             right[i][n - 1] = heightMap[i][n - 1];
//         }
//         for(int i = 0; i < m; i++){
//             for(int j = n-2; j >= 0; j--){
//                 right[i][j] = Math.max(right[i][j + 1], heightMap[i][j+1]);
//             }
//         }
//         System.out.println("Right Array:");
//         print(right);


//         int[][] up = new int[m][n];
//         for(int i = 0; i < n; i++){
//             up[0][i] = heightMap[0][i];
//         }
//         for(int i = 1; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 up[i][j] = Math.max(up[i-1][j], heightMap[i-1][j]);
//             }
//         }
//         System.out.println("Up Array:");
//         print(up);


//         int[][] down = new int[m][n];
//         for(int i = 0; i < n; i++){
//             down[m-1][i] = heightMap[m-1][i];
//         }
//         for(int i = m-2; i >= 0; i--){
//             for(int j = 0; j < n; j++){
//                 down[i][j] = Math.max(down[i+1][j], heightMap[i+1][j]);
//             }
//         }
//         System.out.println("Down Array:");
//         print(down);

//         int[][] result = new int[m][n];
//         int collected = 0;
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 int min = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));
//                 int height = min - heightMap[i][j];
//                 if(height >= 0){
//                     result[i][j] = height;
//                     collected += height;
                    
//                 }
//             }
//         }
//         System.out.println("Result Array:");
//         print(result);
        
//         return collected;
//     }

//     private void print(int[][] array) {
//         for (int[] row : array) {
//             for (int value : row) {
//                 System.out.print(value + " ");
//             }
//             System.out.println();
//         }
//     }
    
// }


class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length; // Grid rows
        int n = heightMap[0].length; // Grid columns
        
        // Step 1: Initialize volumes with terrain heights
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }

        // Step 2: Iterative spreading to enforce constraints
        boolean upt = true;
        boolean init = true;
        while (upt) {
            upt = false;
            
            // Pass 1: Spread constraints from top-left to bottom-right
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j], 
                                       Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            // Pass 2: Spread constraints from bottom-right to top-left
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], 
                                       Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        // Step 3: Calculate total trapped water
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}
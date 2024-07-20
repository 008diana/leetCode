//NMS, my approach was waaaaaaaayyyyy longer. this is nice
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] ansMatrix = new int[rows][cols];

        // Iterate over each cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Determine the minimum value between the current rowSum and colSum
                int minVal = Math.min(rowSum[i], colSum[j]);
                // Assign this minimum value to the matrix cell
                ansMatrix[i][j] = minVal;
                // Subtract this value from the current rowSum and colSum
                rowSum[i] -= minVal;
                colSum[j] -= minVal;
            }
        }

        return ansMatrix;
    }
}

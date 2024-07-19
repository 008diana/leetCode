class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> solution = new ArrayList<>();
        int column = 0;

        for(int i = 0; i < matrix.length; i++){
            column = MinInRowIndex(matrix, i);
            if(checkMax(matrix, i, column)){
                solution.add(matrix[i][column]);
            }

        }
        return solution;
         
    }

    private int MinInRowIndex (int[][] matrix, int row){
        int min = Integer.MAX_VALUE;
        int columnValue = -1;
        for(int j = 0; j < matrix[row].length; j++){
            if(matrix[row][j] < min){
                min = matrix[row][j];
                columnValue = j;
            }
        }
        return columnValue;
    } 

    private boolean checkMax (int[][] matrix, int row, int column){
        int max = matrix[row][column];
        for (int j = 0; j < matrix.length; j++){
            if(matrix[j][column] > max){
                return false;
            }
        }
        return true;

    }
}

/*
1) first the minimum element in the row
2) then find if it is the maximum in the column
*/
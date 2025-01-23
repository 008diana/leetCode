class Solution {
    public int countServers(int[][] grid) {
        int counter = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] columns = new int[n];

        for(int i = 0; i < m; i++){
            rows[i] = 0;
        }

        for(int j = 0; j < n; j++){
            columns[j] = 0;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rows[i]++;
                    columns[j]++;
                } 
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    if(rows[i] >= 2 || columns[j] >= 2){
                        counter++;
                    }
                } 
            }
        }

        return counter;

    }
}
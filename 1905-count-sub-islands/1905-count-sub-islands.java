//happy that i figured it out!
class Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        HashMap<Integer, ArrayList<int[]>> uniqueIslands = new HashMap<>();
        int islandCounter = 0;
        int validSubIslands = 0;

        // Step 1-5: Identify and store all islands in grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    makeIsland(grid2, islandCounter, i, j, uniqueIslands);
                    islandCounter++;
                }
            }
        }

        // Step 6: Check each island in grid2 against grid1
        for (int islandNumber = 0; islandNumber < islandCounter; islandNumber++) {
            boolean isSubIsland = true;

            // Get the coordinates for the current island number
            ArrayList<int[]> coordinates = uniqueIslands.get(islandNumber);

            
             for (int i = 0; i < coordinates.size(); i++) {
                int[] coord = coordinates.get(i);
                int x = coord[0];
                int y = coord[1];

                // If any part of the island in grid2 is not 1 in grid1, it's not a sub-island
                if (grid1[x][y] != 1) {
                    isSubIsland = false;
                    break;
                }
            }

            // If the island is a valid sub-island, increment the counter
            if (isSubIsland) {
                validSubIslands++;
            }
        }

        // Step 7: Return the final count of valid sub-islands
        return validSubIslands;
    }

    public static void makeIsland(int[][] grid2, int counter, int i, int j, HashMap<Integer, ArrayList<int[]>> uniqueIslands) {
        int m = grid2.length;
        int n = grid2[0].length;

        // Add the current coordinate to the island's ArrayList
        uniqueIslands.computeIfAbsent(counter, k -> new ArrayList<>()).add(new int[]{i, j});
        grid2[i][j] = -1;

        // Check right
        if (j < n - 1 && grid2[i][j + 1] == 1) {
            makeIsland(grid2, counter, i, j + 1, uniqueIslands);
        }

        // Check left
        if (j > 0 && grid2[i][j - 1] == 1) {
            makeIsland(grid2, counter, i, j - 1, uniqueIslands);
        }

        // Check up
        if (i > 0 && grid2[i - 1][j] == 1) {
            makeIsland(grid2, counter, i - 1, j, uniqueIslands);
        }

        // Check down
        if (i < m - 1 && grid2[i + 1][j] == 1) {
            makeIsland(grid2, counter, i + 1, j, uniqueIslands);
        }
    }
}
/*
how to solve?
1) go to grid 2.
2) start iterating from top left of the grid.
3) if you encounter a 1, enter its coordinates to an hashmap (int , arraylist which contains x and y coordinates) with 1, {x,y}.(
4) check left right, up and down if you find a 1 repeat step 3 and 4
5) if you encounter a 0 return, and the next one encountered should go to the hashmap withthe value 2, then 3 and so on.. this will store all the ubique islands and their coordinate values across which they are spread. store the number of unique islands as counter
6) now access grid 1. for each coordinate in the hashmap correspondig to 1 in the hashmap,the grid1 should contain 1, if it does not counter--
7) return counter
*/

//got it!
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int currX = 0;
        int currY = 0;
        int maxDistance = 0;
        String currDir = "North";

        // Store obstacles in a HashSet for O(1) lookup
        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        

        for (int command : commands) {
            if (command == -1 || command == -2) {
                currDir = facing(currDir, command);
            } 
            else {
                for (int step = 0; step < command; step++) {
                    int nextX = currX;
                    int nextY = currY;

                    // Calculate the next position based on the current direction
                    if (currDir.equals("North")) {
                        nextY += 1;
                    } 
                    else if (currDir.equals("East")) {
                        nextX += 1;
                    } 
                    else if (currDir.equals("South")) {
                        nextY -= 1;
                    } 
                    else if (currDir.equals("West")) {
                        nextX -= 1;
                    }

                    // Check if the next position is an obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; // Stop moving in this direction if there's an obstacle
                    } 

                     
                    else {
                        // Update the current position
                        currX = nextX;
                        currY = nextY;
                        // Update the maximum Euclidean distance squared
                        int distance = currX * currX + currY * currY;
                        maxDistance = Math.max(maxDistance, distance);
                    }
                }
            }
        }

        return maxDistance;
    }

    public static String facing(String currDir, int command) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("North", 0);
        hm.put("East", 1);
        hm.put("South", 2);
        hm.put("West", 3);
        int indexCurr = hm.get(currDir);
        String[] directions = { "North", "East", "South", "West" };
        if (command == -1) {
            indexCurr = (indexCurr + 1) % 4;
        } else if (command == -2) {
            indexCurr = (indexCurr + 3) % 4; // Adjust to ensure no negative index
        }

        return directions[indexCurr];
    }
}

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        
        // Map to store which ball has which color
        HashMap<Integer, Integer> ballColor = new HashMap<>();
        // Map to count how many balls have each color
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];
            
            // If ball already has a color
            if(ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);
                // Decrease count of old color
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                // Remove color if count becomes 0
                if(colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }
            
            // Add new color
            ballColor.put(ball, newColor);
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);
            
            result[i] = colorCount.size();
        }
        
        return result;
    }
}
class Solution {
    public int heightChecker(int[] heights) {
        int counter = 0;
        int[] heightsOri = new int[heights.length];
        for(int i = 0; i< heights.length; i++){
            heightsOri[i] = heights[i];
        }
        Arrays.sort(heights);
        for(int i = 0; i < heights.length; i++){
            if(heightsOri[i] != heights[i]){
                counter++;
            }
        }
        return counter;

    }
}
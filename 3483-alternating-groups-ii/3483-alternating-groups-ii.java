class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;
        int n = colors.length;
        int[] colorsCirclular = new int[n + k - 1];
        for(int i = 0; i < n + k - 1; i++){
            if(i < n){
                colorsCirclular[i] = colors[i];
            }
            else{
                colorsCirclular[i] = colors[i-n];
            }

        }
        int counter = 1;
        int j = 0;
        while(j < (n + k - 1) - 1){
            while(j < (n + k - 1) - 1 && colorsCirclular[j] != colorsCirclular[j+1]){
                counter++;
                j++;
            }
            System.out.println(counter);
            if(counter >= k){
                result += counter - k + 1;
                counter = 1;
            }
            
            else{
                counter = 1;
            }
            System.out.println(result);
            j++;
        }
        return result;
    }
}
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int counter = 0;
        for(int i = 0 ; i < k; i++){
            if(blocks.charAt(i) == 'B'){
                counter++;
            }
        }
        int max = counter;
        int left = 0;
        int right = k;
        for(int i = k; i < n; i++){
            if(blocks.charAt(left) == 'B'){
                counter--;
            }
            if(blocks.charAt(right) =='B'){
                counter++;
            }
            max = Math.max(counter, max);
            left++;
            right++;
        }

        return k - max;
    }
}
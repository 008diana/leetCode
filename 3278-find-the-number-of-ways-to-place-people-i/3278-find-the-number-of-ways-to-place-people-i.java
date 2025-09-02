class Solution {
    public int numberOfPairs(int[][] points) {
       int result = 0;
       int xa, ya, xb, yb;
       int n = points.length;
       for(int i = 0; i < n; i++){
        xa = points[i][0];
        ya = points[i][1];
        for(int j = 0; j < n; j++){
            xb = points[j][0];
            yb = points[j][1];
            if(checkUpperLeft(i, j, xa, xb, ya, yb) && checkNoPoint(i , j , xa, xb, ya, yb, points)){
                result++;
            }
        }
       }
       return result; 
    }

    public boolean checkUpperLeft (int i, int j, int xa, int xb, int ya, int yb){
        if(i != j){
            if(xa <= xb && ya >= yb){
            return true;
        }
        }
        
        return false;
    }

    public boolean checkNoPoint(int i, int j , int xa, int xb, int ya, int yb, int[][] points){
        int n = points.length;
        for(int k = 0; k < n; k ++){
            if (k != i && k != j){
                int kx = points[k][0];
                int ky = points[k][1];
                if(kx <= xb && kx >= xa && ky <= ya && ky >= yb){
                    return false;
                }
            }
        }
        return true;
    }
}
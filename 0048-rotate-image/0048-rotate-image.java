//my first 100% !!!!lfkhagamdf ;klcoe fjwelc
class Solution {
    public void rotate(int[][] matrix) {


        int n = matrix.length;
        int limit = (n*n)/4;
        int left = 0;
        int right = n -1;
        int top = 0;
        int bottom = n -1;
        int A = 0;
        int B = 0; 
        int C = n-1;
        int D = n -1;
        int counter = 0;

        while(counter != limit){

            int temp = matrix[top][A];
            matrix[top][A] = matrix[D][left];
            matrix[D][left] = matrix[bottom][C];
            matrix[bottom][C] = matrix[B][right];
            matrix[B][right] = temp;
            
            A++;
            B++;
            C--;
            D--;

            counter++;

            if(A == right){
                left++;
                right--;
                top++;
                bottom--;
                A = left;
                B = top;
                C = right;
                D = bottom;
            }
        }

        return;
        
    }
}
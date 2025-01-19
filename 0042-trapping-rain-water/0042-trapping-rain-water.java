class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int sum = 0;

        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];

        int[] maxRight = new int[n];
        maxRight[n-1] = height[n-1];

        int[] calculatedVal = new int[n];

        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i - 1]);            
        }
        // for(int i = 0; i < n; i++){
        //     System.out.print(maxLeft[i] + " ");
        // }

        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);            
        }
        // for(int i = 0; i < n; i++){
        //     System.out.print(maxRight[i] + " ");
        // }

        for(int i = 0; i < n; i++){
            calculatedVal[i] = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(calculatedVal[i] > 0){
                sum = sum + calculatedVal[i];
            }
        }
        // for(int i = 0; i < n; i++){
        //     System.out.print(calculatedVal[i] + " ");
        // }
        
        return sum;
    }
}
 
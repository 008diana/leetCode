class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            ans[i] = XOR(arr, queries, i);
        }
        return ans;
    }

    public static int XOR(int[] arr, int[][] queries, int i){
        int start = queries[i][0]; 
        int end = queries[i][1];
        int ans = arr[start]; 
        for(int j = start + 1; j <= end; j++){
            ans = arr[j] ^ ans;
        }
        return ans;
    }
}
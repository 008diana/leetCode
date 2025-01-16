class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0; 
        if(n % 2 == 0 && m % 2 == 0){
            return 0;
        }
        if(m % 2 == 0 && n%2 != 0){
            for(int i = 0; i < m; i++){
                ans ^= nums2[i];
            }
            return ans;
        }
        if(n % 2 == 0 && m %2 != 0){
            for( int i = 0; i < n; i++){
                ans ^= nums1[i];
            }
            return ans;
        }
        
            int ans2 = 0;
            for( int i = 0; i < m; i++){
                ans ^= nums2[i];
                
            }
            for( int i = 0; i < n; i++){
                ans2 ^= nums1[i];
                
            }
            return ans^ans2;
        
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int o = m + n;
        //float median;
        int[] nums3 = new int [o];
        for(int i = 0 ; i < m; i++){
            nums3[i] = nums1[i];
        }
        for (int i = 0; i < n; i++){
            nums3[m + i] = nums2[i];
        }
        Arrays.sort(nums3);
        if( o % 2 == 0){
            return (float)(nums3[o/2] + nums3[(o/2) - 1]) / 2;
        }
        else{
            return nums3[o/2];
        }
        

    }
}
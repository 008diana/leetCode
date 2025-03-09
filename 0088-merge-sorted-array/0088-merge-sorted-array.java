class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    // If nums2 is empty, nothing to do
    if (n == 0) {
        return;
    }
    
    // First pass: Compare and swap
    for (int i = 0; i < m; i++) {
        if (nums1[i] > nums2[0]) {
            // Swap with first element of nums2
            int temp = nums1[i];
            nums1[i] = nums2[0];
            nums2[0] = temp;
            
            // Reposition the swapped element in nums2 to maintain sort
            int j = 0;
            while (j < n - 1 && nums2[j] > nums2[j + 1]) {
                temp = nums2[j];
                nums2[j] = nums2[j + 1];
                nums2[j + 1] = temp;
                j++;
            }
        }
    }
    
    // Copy remaining elements from nums2 to nums1
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }
}
}
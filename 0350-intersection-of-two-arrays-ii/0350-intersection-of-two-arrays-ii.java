class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap <Integer, Integer> hm = new HashMap<>();
        int size;
        
        if(nums1.length >= nums2.length){
            size = nums1.length;
        }
        else{
            size = nums2.length;
        }

        int[] result = new int[size];
        int r = -1;

        for(int i = 0; i < nums1.length; i++){
            if(hm.containsKey(nums1[i])){
                hm.put(nums1[i], hm.get(nums1[i]) + 1);
            }
            else{
                hm.put(nums1[i], 1);
            }
        }
        int newSize = 0;
        for(int i = 0; i < nums2.length; i++){
            if(hm.containsKey(nums2[i]) && hm.get(nums2[i]) != 0){
                r++;
                newSize = r + 1;
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
                result[r] = nums2[i];
            }
        }

        int[] finalResult = new int[newSize];
        for (int i = 0; i < newSize; i++){
            finalResult[i] = result[i];
        }


        return finalResult;
        
    }
}
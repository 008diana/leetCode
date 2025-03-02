class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int length1 = nums1.length;
        int length2 = nums2.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < length1; i++){
            int id = nums1[i][0];
            int value = nums1[i][1];
            map.put(id, value);
        }

        for(int i = 0; i < length2; i++){
            int id = nums2[i][0];
            int value = nums2[i][1];
            if(map.containsKey(id)){
                map.put(id, map.get(id) + value);
            }
            else{
                map.put(id, value);
            }
        }

        int size = map.size();

        int[][] result = new int[size][2];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }

        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
        
        return result;
    }
}
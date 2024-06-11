class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int r = 0;
        int[] result = new int[arr1.length];
        Arrays.sort(arr1);
        HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();

        for(int  i = 0; i < arr2.length; i++){
            hm2.put(arr2[i], 1);
        }  

        for(int i = 0; i < arr1.length; i++){
            if(hm2.containsKey(arr1[i])){
                if(hm1.containsKey(arr1[i])){
                    hm1.put(arr1[i], hm1.get(arr1[i]) + 1);
                }
                else{
                    hm1.put(arr1[i], 1);
                }
                arr1[i] = -1;
            }
            
        }


        for(int i = 0; i < arr2.length; i++){
            int k = hm1.get(arr2[i]);
                for(int j = 0; j < k; j++){
                    result[r] = arr2[i];
                    r++;  
                }
        }

        for(int i = 0; i < arr1.length; i++){

            if(arr1[i] != -1){
                result[r] = arr1[i];
                r++;
            }

        }

    return result;
    }
}
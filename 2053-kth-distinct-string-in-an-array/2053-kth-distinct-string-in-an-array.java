//after 1 logical error, here we are
class Solution {
    public String kthDistinct(String[] arr, int k) {

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            String key = arr[i];
            if(frequencyMap.containsKey(key)) {
                frequencyMap.put(key, frequencyMap.get(key) + 1);
            }
            else {
                frequencyMap.put(key, 1);
            }
        }

        ArrayList<String> apnaList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            String key = arr[i];
            if(frequencyMap.get(key) == 1) {
                apnaList.add(key);
            }
        }

        if (apnaList.size() >= k) {
            return apnaList.get(k - 1);
        }

        return "";
    }

}
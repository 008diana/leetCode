//getting more familiar with ArrayLists, by the day!
class Solution {
    public int minimumPushes(String word) {
        int presses = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            }
            else {
                hm.put(c, 1);
            }
        }

        ArrayList<Integer> apnaList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(hm.containsKey(c)) {
                apnaList.add(hm.get(c));
                hm.remove(c);
            } 
        }
        Collections.sort(apnaList, Collections.reverseOrder());

        for(int i = 0; i < apnaList.size(); i++) {
            if (i <= 7) {
                presses += apnaList.get(i) * 1;
            }
            else if (i > 7 && i <= 15) {
                presses += apnaList.get(i) * 2;
            }
            else if (i > 15 && i <= 23) {
                presses += apnaList.get(i) * 3;
            }
            else {
                presses += apnaList.get(i) * 4;
            }
        }
        return presses;
    }
}
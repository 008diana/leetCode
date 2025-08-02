class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int start = 0;
        int end = 1;
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(fruits[0], 1);
        
        while (start < n && end < n) {
            int fruit = fruits[end];
            
            if (map.containsKey(fruit)) {
                int currVal = map.get(fruit);
                map.put(fruit, currVal + 1);
                max = Math.max(end - start + 1, max);
                end++;
                //System.out.println("Start:" + start + " Max:" + max + " Map:" + map + " End:" + end + " first");
            } 
            else if (!map.containsKey(fruit) && map.size() != 2) {
                max = Math.max(end - start + 1, max);
                map.put(fruit, 1);
                end++;
                //System.out.println("Start:" + start + " Max:" + max + " Map:" + map + " End:" + end + " second");
            } 
            else {
                while (map.size() == 2) {  // ⬅️ fix: run until size == 1 is incorrect
                    int val = map.get(fruits[start]);  // ⬅️ fix: use getOrDefault
                    if (val == 1) {
                        map.remove(fruits[start]);
                    } else {
                        map.put(fruits[start], val - 1);
                    }
                    start++;
                }

                map.put(fruit, 1);
                max = Math.max(end - start + 1, max);
                end++;  // ⬅️ fix: missing end++ here
                //System.out.println("Start:" + start + " Max:" + max + " Map:" + map + " End:" + end + " third");
            }
        }
        return max;
    }
}

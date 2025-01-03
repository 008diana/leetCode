class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, int[]> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                map.put(ch, new int[]{i, i});
                map2.put(i, i);
            }
            else{
                map.get(ch)[1] = i;
                map2.put(map.get(ch)[0], i);
            }
        }
        
        // Print first map (character -> [start, end] indices)
        System.out.println("Map 1 (Character -> [start, end]):");
        for(Map.Entry<Character, int[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> [" + entry.getValue()[0] + ", " + entry.getValue()[1] + "]");
        }
        
        // Print second map (start index -> end index)
        System.out.println("\nMap 2 (Start index -> End index):");
        for(Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        int upper = map2.get(0);
        int lower = 0; 
        //int currCount = 0;

        while(upper <= n - 1){
            for(int i = lower + 1; i < upper; i++){
                if(map2.containsKey(i)){
                    if(map2.get(i) > upper){
                    upper = map2.get(i);
                    }
                }
                
            }
            list.add(upper - lower + 1);
            lower = upper + 1;
            if(lower == n){
                break;
            }
            upper = map2.get(lower);
            
        }

        
        return list;
    }
}
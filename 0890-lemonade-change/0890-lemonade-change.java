class Solution {
    public boolean lemonadeChange(int[] bills) {
        boolean result = true;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = bills.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            int curr = bills[i];
            if(curr == 5){
                map.put(5, map.getOrDefault(5, 0) + 1);
                total += 5;
            }
            if(curr == 10){
                if(map.containsKey(5) && map.get(5) != 0){
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    total += 5;
                    map.put(10, map.getOrDefault(10, 0) + 1);
                }
                else{
                    return false;
                }
            }
            if(curr == 20){
                if(total < 15){
                    return false;
                }
                else{
                    if(map.containsKey(10) && map.containsKey(5) && map.get(10) != 0 && map.get(5) != 0){
                        map.put(5, map.getOrDefault(5, 0) - 1);
                        map.put(10, map.getOrDefault(10, 0) - 1);
                        total += 5;
                    }
                    else if (map.containsKey(5) && map.get(5) >= 3){
                        map.put(5, map.getOrDefault(5, 0) - 3);
                        total +=5;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return result;
    }
}
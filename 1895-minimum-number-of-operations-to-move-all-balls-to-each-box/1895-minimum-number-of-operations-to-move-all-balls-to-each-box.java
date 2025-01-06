class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int [n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char ch = boxes.charAt(i);
            if(ch == '1'){
                list.add(i + 1);
            }
        }
        // numbers.replaceAll(num -> num - 1);
        for(int i = 0; i < n; i++){
            list.replaceAll(num -> num - 1);
            int sum = 0;
            for (int num : list) {
                if(num < 0){
                    sum += -num;
                }
                else{
                    sum += num;
                }
                
            }
            result[i] = sum;
        }
        return result;
    }
}
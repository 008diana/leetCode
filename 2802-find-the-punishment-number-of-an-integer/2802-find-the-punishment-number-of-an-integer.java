class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(checkCondition2(i)){
                sum += i*i;
            }
        }
        return sum;
    }

    public static boolean checkCondition2(int num){
        int squaredNum = num * num;
        int digits = getDigits(squaredNum);
        
        ArrayList<Integer> list = new ArrayList<>();
        return check(squaredNum, 0, list, num, digits - 1);
    }

    public static int getDigits(int num){
        int result = 0;
        while(num > 0){
            result++;
            num = num/10;
        }
        return result;
    }

    public static boolean check(int squaredNum, int index, ArrayList<Integer> list, int target, int spaces){
        // Base case: if we've reached beyond the last possible split point
        if(index == spaces) {
            return calc(list, squaredNum) == target;
        }

        // Try without including current index
        boolean notInclude = check(squaredNum, index + 1, list, target, spaces);

        // Try including current index
        list.add(index);
        boolean include = check(squaredNum, index + 1, list, target, spaces);
        list.remove(list.size() - 1);  // Backtrack

        return include || notInclude;
    }

    public static int calc(ArrayList<Integer> splitIndices, int number) {
        String numStr = String.valueOf(number);
        int sum = 0;
        int startIndex = 0;
        
        Collections.sort(splitIndices);
        
        for (int index : splitIndices) {
            String part = numStr.substring(startIndex, index + 1);
            sum += Integer.parseInt(part);
            startIndex = index + 1;
        }
        
        if (startIndex < numStr.length()) {
            String lastPart = numStr.substring(startIndex);
            sum += Integer.parseInt(lastPart);
        }
        
        return sum;
    }
}
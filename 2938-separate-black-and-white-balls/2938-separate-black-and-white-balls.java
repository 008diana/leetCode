class Solution {
    public long minimumSteps(String s) {
        int countOne = 0;
        int n = s.length();
        int r = -1;
        int[] arr = new int[n];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                r++;
                arr[r] = i;
                countOne++;
            }
        }
        int k = n -1;
        long steps = 0;
        for (int j = countOne - 1; j >= 0; j--) {
            steps = steps + k - arr[j];
            k--;
        }

        return steps;
    }
}
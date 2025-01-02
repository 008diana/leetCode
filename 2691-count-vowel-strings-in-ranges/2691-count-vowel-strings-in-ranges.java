class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int m = words.length;
        int[] res = new int[n];
        int[] prefixSum = new int[m + 1];
        prefixSum[0] = 0;

        for (int i = 1; i <= m; i++) {
            String word = words[i - 1];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } 
            else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            res[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }

        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

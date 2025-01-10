class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        // Get maximum frequency for each character across all words2
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] curr = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], curr[i]);
            }
        }
        
        // Check each word in words1
        for (String word : words1) {
            int[] freq = getFrequency(word);
            boolean isUniversal = true;
            
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            
            if (isUniversal) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
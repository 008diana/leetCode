//compiler tommorow ;P
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        // Split both sentences into words
        String[] smaxArray1 = s1.split(" ");
        String[] sminArray2 = s2.split(" ");

        // Use a HashMap to count occurrences of each word
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        // Count words in the first sentence
        for (String word : smaxArray1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Count words in the second sentence
        for (String word : sminArray2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect uncommon words (those that appear exactly once in one sentence and not in the other)
        ArrayList<String> result = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) { // Appears exactly once in total
                result.add(word);
            }
        }

        // Convert result to array and return it
        return result.toArray(new String[0]);
    }
}

//getting hang of rolling hash a little
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Edge case: If the string is shorter than 10, return an empty list
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        // Precompute powers of 4
        int[] pows = new int[10];
        for (int i = 0; i < 10; i++) {
            pows[i] = (int) Math.pow(4, i);
        }

        // Map nucleotides to numbers
        HashMap<Character, Integer> d = new HashMap<>();
        d.put('A', 0);
        d.put('C', 1);
        d.put('G', 2);
        d.put('T', 3);

        // Set to store final repeated sequences
        Set<String> ans = new HashSet<>();

        // Initialize current hash for the first 10 characters
        int curr = 0;
        for (int i = 0; i < 10; i++) {
            curr += d.get(s.charAt(i)) * pows[9 - i];
        }

        // Set to store already seen hashes
        Set<Integer> z = new HashSet<>();
        z.add(curr);

        // Sliding window over the string
        for (int i = 10; i < s.length(); i++) {
            // Update the current hash by sliding the window
            curr = (curr - d.get(s.charAt(i - 10)) * pows[9]) * 4 + d.get(s.charAt(i));

            // If current hash is already seen, add the substring to ans
            if (z.contains(curr)) {
                ans.add(s.substring(i - 9, i + 1));
            }
            z.add(curr);
        }

        // Convert set of answers to a list and return
        return new ArrayList<>(ans);
    }
}

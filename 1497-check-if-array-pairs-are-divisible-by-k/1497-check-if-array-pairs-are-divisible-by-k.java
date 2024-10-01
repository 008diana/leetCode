// to find the correct modulo for bith negative and positive numbers always use the formula ((num % k) + k) % k
class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int remainder = ((num % k) + k) % k;
            hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);
        }

        // Check if the frequency of remainder 0 is even
        if (hm.containsKey(0)) {
            if (hm.get(0) % 2 != 0) {
                return false;
            }
        }

        // Check if complementary remainder pairs have the same frequency
        for (int key : hm.keySet()) {
            if (key == 0) {
                continue; // Skip the remainder 0, as it is already checked
            }

            int complement = k - key;
            // Check if the complement exists and has the same frequency
            if (!hm.containsKey(complement) || !hm.get(key).equals(hm.get(complement))) {
                return false;
            }
        }

        return true;
    }
}

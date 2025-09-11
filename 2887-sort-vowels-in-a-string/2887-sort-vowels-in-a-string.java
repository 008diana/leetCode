class Solution {
    public String sortVowels(String s) {
        char[] t = s.toCharArray();  
        String vowels = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (!isConsonant(s.charAt(i))) {
                vowels += s.charAt(i);
                t[i] = '-';  
            }
        }

        char[] chars = vowels.toCharArray();
        Arrays.sort(chars);
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (t[i] == '-') {
                t[i] = chars[m];
                m++;
            }
        }

        return new String(t); 
    }

    public static boolean isConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        return consonants.contains(String.valueOf(c));
    }
}

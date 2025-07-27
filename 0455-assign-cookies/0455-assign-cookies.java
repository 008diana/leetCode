class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int j = 0;
        int counter = 0;
        for (int i = 0; i < s.length; i++) {
            if (j < g.length && g[j] <= s[i]) {
                counter++;
                j++;
            }
        }
        return counter;
    }
}

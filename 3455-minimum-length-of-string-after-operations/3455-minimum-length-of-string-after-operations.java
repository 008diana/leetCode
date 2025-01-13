class Solution {

    public int minimumLength(String s) {
        int n = s.length();
        int[] arr = new int[26];
        int length = n;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
            if(arr[ch -'a'] == 3){
                length -= 2;
                arr[ch - 'a'] -= 2;
            }
        }
        return length;
    }
}
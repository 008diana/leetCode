class Solution {
    // Helper method to print the array
    private void print(int[] arr) {
        System.out.print("Array values: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int minimumLength(String s) {
        int n = s.length();
        int[] arr = new int[26];
        int length = n;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
            //print(arr);
            if(arr[ch -'a'] == 3){
                length -= 2;
                arr[ch - 'a'] -= 2;
            }
        }
        return length;
    }
}
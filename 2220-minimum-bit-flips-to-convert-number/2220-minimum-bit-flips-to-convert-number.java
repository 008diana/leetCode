//done!
class Solution {
    public int minBitFlips(int start, int goal) {
        String str = Integer.toBinaryString(start);
        String str1 = Integer.toBinaryString(goal);
         int maxLength = Math.max(str.length(), str1.length());

        // Pad str with leading zeros
        while (str.length() < maxLength) {
            str = "0" + str;
        }

        // Pad str1 with leading zeros
        while (str1.length() < maxLength) {
            str1 = "0" + str1;
        }

        int counter = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str1.charAt(i)) {
                counter++;
            }
        }
        return counter;
        
    }
}
/*
something new solution:
class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0; 
        int xor = start ^ goal; // XOR will give 1 where the bits differ

        while(xor!=0){
            count += xor & 1; // Increment count if the last bit is 1
            xor >>=1; // Right-shift to check the next bit
        }
        return count;
    }
}
*/
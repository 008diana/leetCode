//yay, i guess XD!
class Solution {
    public int findComplement(int num) {
        String ans = "";
        while (num != 0) {
            int remainder = num % 2;
            num = num / 2;
            if(remainder == 1) {
                ans = '0' + ans;
            }
            else {
                ans = '1' + ans;
            }
        }
        int power = 0;
        int ansNUmber = 0;
        for(int i = ans.length() - 1; i >= 0; i--) {
            int multi = ans.charAt(i) - '0';
            ansNUmber += Math.pow(2, power) * multi;
            power++;
        }
        return ansNUmber;
    }
}
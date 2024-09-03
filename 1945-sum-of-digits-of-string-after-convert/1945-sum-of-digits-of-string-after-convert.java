//now i know hoe to debug using print!
class Solution {

    public int getLucky(String s, int k) {

        int j = 0;
        String ans = "";

        for(int i = 0; i < s.length(); i++) {
            ans = ans + String.valueOf((int)s.charAt(i) - 96);
        }
        //System.out.println(ans);

        while(j < k) {
            int sum = 0;
            for(int i = 0; i < ans.length(); i++){
            sum = sum + (int)(ans.charAt(i) - '0');
            //System.out.println(sum);
            }
            //System.out.println(j);
            ans = String.valueOf(sum);
            j++;
        }

    return Integer.valueOf(ans);
        
    }
}
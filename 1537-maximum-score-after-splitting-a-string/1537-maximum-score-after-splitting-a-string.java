class Solution {
    public int maxScore(String s) {
        int n = s.length();
       int max = Integer.MIN_VALUE;
       int zeroes = 0;
       int ones = 0;
       int[] result =  new int[n -  1];
       //int[] result1 =  new int[n -  1];
       for(int i = 0; i < n - 1; i ++){
        if(s.charAt(i) == '0'){
            zeroes++;
            result[i] = zeroes;
            System.out.print(result[i] + " ");
        }
        else{
            result[i] = zeroes;
            System.out.print(result[i] + " ");
        }
       }
       
       
       
       for(int i = n-2; i >= 0; i--){
        if(s.charAt(i+1) == '1'){
            ones++;
            result[i] += ones;
            System.out.print(result[i] + " ");
        }
        else{
            result[i] += ones;
            System.out.print(result[i] + " ");
        }
       }

       System.out.println(" ");

       for(int i = 0; i < n-1; i++){
        System.out.print(result[i] + " ");
        if(result[i] > max){
            max = result[i];
        }
       }
       return max;
    }
}
class Solution {
    public int passThePillow(int n, int time) {
        boolean flag = true;
        int reverseDirection = n - 1;//3
        int i = 1;
        int currTme = 0;
        while (currTme != time){
            if(reverseDirection != 0 && flag == true){
                i++;
                reverseDirection--;
                currTme++;
            }
            else{
                flag = false;
                if (reverseDirection != n - 1){
                    reverseDirection++;
                    i--;
                    currTme++;
                }
                else{
                    flag = true;
                }
                
            }
        }
        return i;
    }
}
//n -1 moves to reach each end
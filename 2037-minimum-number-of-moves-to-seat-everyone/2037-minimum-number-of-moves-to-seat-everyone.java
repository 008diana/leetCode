class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int difference = 0;
        int currDifference;
        int n = seats.length;
        int i;
        for(i = 0; i < n; i++){
            currDifference = students[i] - seats[i];
            if (currDifference >= 0){
                difference = difference + currDifference;
            }
            else{
                difference = difference - currDifference;
            } 
        } 
        return difference;
        
    }
}
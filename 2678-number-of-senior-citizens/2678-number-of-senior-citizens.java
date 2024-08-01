//extremely easy. Still made a logical mistake! learnt something!
class Solution {
    public int countSeniors(String[] details) {

     int counter = 0;
     for (int i = 0; i < details.length; i++){
        char age = details[i].charAt(11);
        int ageVal = age - '0';
        char age2 = details[i].charAt(12);
        int ageVal2 = age2 - '0';
        
        int finalAge = (ageVal * 10) + ageVal2;
        if (finalAge > 60){
            counter++;
        }
     }
    return counter;
    }
}
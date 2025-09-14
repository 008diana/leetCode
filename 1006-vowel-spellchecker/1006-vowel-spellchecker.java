class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        int m = wordlist.length;
        String[] wordListLower = new String[m];
        String[] wordListLowerCVForm = new String[m];
        String[] answer = new String[n];
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            set.add(wordlist[i]);
            String word = wordlist[i].toLowerCase();
            wordListLower[i] = word;
            String vowelized ="";
            for(int k = 0; k < word.length(); k++){
                
                if(isVowel(word.charAt(k))){
                    vowelized = vowelized + "!";
                }
                else{
                    vowelized = vowelized + word.charAt(k);
                }
            }
            wordListLowerCVForm[i] = vowelized;
        }
        for(int j = 0; j < n; j++){
            String queryWord = queries[j];
            String queryWordLower = queryWord.toLowerCase();
            answer[j] = "";
            if(set.contains(queryWord)){
                answer[j] = queryWord;
            }
            else if(captalized(wordListLower, queryWordLower, j) != -1){
                answer[j] = wordlist[captalized(wordListLower, queryWordLower, j)];
            }
            else if(vowelErrors(wordListLowerCVForm, queryWordLower) != -1){
                answer[j] = wordlist[vowelErrors(wordListLowerCVForm, queryWordLower)];
            }
        }
        return answer;
    }

    public static int captalized(String[] wordListLower, String queryWordLower, int j){
        int m = wordListLower.length;
        //System.out.println(queryWordLower);
        //System.out.println();
        for(int i = 0; i < m; i++){
            
            //System.out.println(queryWordLower);
            
            if(wordListLower[i].equals(queryWordLower)){
                //System.out.println("true!");
                return i;
            }
        } 
        //System.out.println("false!");
        return -1;
    }

    public static int vowelErrors(String[] wordListLowerCVForm, String queryWord){
        int m = wordListLowerCVForm.length;
        String vowelized ="";
        for(int k = 0; k < queryWord.length(); k++){
                if(isVowel(queryWord.charAt(k))){
                    vowelized = vowelized + "!";
                }
                else{
                    vowelized = vowelized + queryWord.charAt(k);
                }
            }
        for(int i = 0; i < m; i++){
            if(wordListLowerCVForm[i].equals(vowelized)){
                return i;
            }
        } 
        return -1;
    }

    public static boolean isVowel(char ch){
        String vowels = "aeiou";
        return vowels.contains(Character.toString(ch));
    }
}
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for(int i = 0; i < n; i++){
            String curr = words[i];
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                else{
                    if(words[j].contains(curr)){
                        res.add(curr);
                        break;
                    }
                }
            }
        }
        return res;
    }
}
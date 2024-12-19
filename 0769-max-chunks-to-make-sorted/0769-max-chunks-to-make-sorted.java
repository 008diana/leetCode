/*
PS, TMI
approach 1: monotonic stack cause that is the topicwise thing jena hu questions aaj kal solve karu chu, passed 21/52 cases, but didn't make sense ena pachi naa cases maate
had to change the notebook page for rough work, cause could not move on from approach 1\U0001f602\U0001f480
next page, somehow logic figure out karyu, and 30 mins later out came the results. I love doing this man
*/
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int counter = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(arr[i], max);
            if(i == max){
                counter++;
                max = Integer.MIN_VALUE;
            }
        }
        return counter;
    }
}
/*
-------------------------ATTEMPT 1---------------------------------
21/52 TEST CASES PASSED BY THIS APPROACH, ENITRELY NEW APPROACH IN SOLUTION
class Solution {
    public int maxChunksToSorted(int[] arr) {

        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        int counter = 0; 

        for(int i = 1; i < n; i++){
            if(!stk.isEmpty() && stk.peek() < arr[i]){
                counter++;
                while(!stk.isEmpty() && stk.peek() < arr[i]){
                    stk.pop();
                }
                stk.push(arr[i]);
                System.out.println(stk);
            }
            else{
                stk.push(arr[i]);
                System.out.println(stk);
            }
            
        }

        if(!stk.isEmpty()){
            counter++;
        }
        
        return counter;
    }
}
 */
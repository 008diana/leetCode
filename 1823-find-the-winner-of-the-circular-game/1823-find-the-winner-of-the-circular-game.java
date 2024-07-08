class Solution {
    public int findTheWinner(int n, int k) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for(int i = 2; i <= n; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        } 
        curr.next = head;
        for(int i = 0; i < n - 1 ; i++){
            for(int j = 0; j < k; j++){
                if(curr.next.val == 0){
                    curr = curr.next;
                    j--;
                }
                else{
                    curr = curr.next;
                }
            }
            curr.val = 0;
        }
        while(curr != null){
            if(curr.val != 0){
                return curr.val;
            }
            curr = curr.next;
        }
        return curr.val;

    }
}
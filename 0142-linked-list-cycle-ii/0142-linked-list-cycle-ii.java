/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        // ListNode slow = head.next;
        // ListNode fast = head.next.next;
        ListNode curr = head;
        int index = 0;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while(curr != null){
            if(!map.containsKey(curr)){
                map.put(curr, index);
                index++;
                curr = curr.next;
            }
            else{
                return curr;
            }
        }
        return null;


    }
}
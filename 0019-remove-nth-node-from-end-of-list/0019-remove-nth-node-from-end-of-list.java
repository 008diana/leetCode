/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode curr = head;
        ListNode ahead = head;
        int counter = 0;
        while(counter != n){
            ahead = ahead.next;
            counter++;
        }
        if(ahead == null){
            return head.next;
        }
        
        
        while(ahead.next != null){
            curr = curr.next;
            ahead = ahead.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
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
    public int getDecimalValue(ListNode head) {
        int i = 0;
        int number = 0;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next  = prev;
            prev = curr;
            curr = temp;
        }
        while (prev != null){
            number += prev.val * Math.pow(2,i);
            i++;
            prev = prev.next;

        }
        
        return number;
    }
}
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
    public ListNode reverseList(ListNode head) {
       ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next; // Temporarily store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to the current node
            curr = next; // Move curr to the next node in the original list
        }
        
        return prev; // prev becomes the new head of the reversed list 
    }
}
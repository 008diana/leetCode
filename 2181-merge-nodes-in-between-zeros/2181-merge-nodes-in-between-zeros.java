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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0); // A dummy node to simplify edge cases
        ListNode curr = head.next; // Skip the first zero node
        ListNode tail = dummy;
        
        int sum = 0;
        while (curr != null) {
            if (curr.val != 0) {
                sum += curr.val;
            } else {
                tail.next = new ListNode(sum); // Create a new node with the sum
                tail = tail.next; // Move the tail
                sum = 0; // Reset the sum
            }
            curr = curr.next;
        }
        
        return dummy.next; // The head of the modified list
    }
}

/*
 my attempt
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        boolean start = false;
        while(curr != null){
            int sum = 0;
            if(curr.val == 0 && start == false){
                sum = 0;
                start = true;
                curr = curr.next;
                //curr.next = curr.next.next;
            }
            else if (curr.val != 0 && start == true){
                while(curr.val != 0){
                    sum += curr.val;
                    curr.val = sum;
                    curr = curr.next;
                }
                start = false;
                curr = curr.next;
                //curr.next = curr.next.next;
            }
            
        }
        return curr;
    }
}
traverse till curr != null
when 0 encountered, start sum
when next 0 encountered end current and start new
when next 0 encountered stop sum
*/

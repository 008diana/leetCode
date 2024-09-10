//solved in record time of 12 minutes!! happy happy!
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode(head.val);
        ListNode curr = head;
        ListNode ahead = head.next;
        ListNode curr1 = dummy;
        while (ahead != null) {
            curr1.next = new ListNode(gcd(curr.val, ahead.val));
            curr1 = curr1.next;
            curr1.next = new ListNode(ahead.val);
            curr1 = curr1.next;
            curr = curr.next;
            ahead = ahead.next;
        }

        return dummy;
    }
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}

/*

*/
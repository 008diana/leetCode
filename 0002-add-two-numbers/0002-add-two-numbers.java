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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag1 = false;
        boolean flag2 = false;
        int carry = 0;
        int ans = 0;
        ListNode curr3 = new ListNode(0);
        ListNode head3 = curr3;
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (curr1 != null || curr2 != null) {
            if (curr1 == null) {
                flag1 = true;
                ans = curr2.val + carry;
            } 
            else if (curr2 == null) {
                flag2 = true;
                ans = curr1.val + carry;
            } 
            else {
                ans = curr1.val + curr2.val + carry;
            }

            if (ans > 9) {
                ans = ans - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            curr3.next = new ListNode(ans);
            curr3 = curr3.next;

            if (!flag1) {
                curr1 = curr1.next;
            }
            if (!flag2) {
                curr2 = curr2.next;
            }
        }

        if (carry == 1) {
            curr3.next = new ListNode(1);
        }

        return head3.next;
    }
}
